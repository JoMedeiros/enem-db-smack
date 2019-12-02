package actors;

import akka.actor.*;
import akka.japi.Pair;
import akka.japi.Predicate;
import messages.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;


public class DbActor extends AbstractActor {

    private Cluster cluster;
    private Session session;

    public DbActor() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").withCredentials("cassandra", "cassandra").build();
        Metadata metadata = cluster.getMetadata();
        //session = cluster.connect("example_play");
        session = cluster.connect("enem_db");
        System.out.printf("@@@@@@@Connected to cluster: %s\n",
                metadata.getClusterName());
    }

    public String queryUser(Long i) {
        ResultSet results = session.execute("SELECT * FROM provas WHERE id = " + i);
        String line = "";
        for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
            Row row = iterator.next();
            line += row.getString("tx_gabarito_ch") + "\n";
        }
        if (line.length() < 1){
            line = "Usuário não encontrado";
        }
        return line;
    }

    public String queryCity(String city) {
        String[] msg = city.split("_");
        ResultSet results = session.execute(
                "SELECT  tx_gabarito_"+ msg[1] + ", tx_respostas_" + msg[1] + " FROM provas WHERE mun_prova = \'"
                        + msg[0] + "\' allow filtering");
        String line = "";
        int total = 0;
        ArrayList<Pair<String, String>> gabarito_resposta = new ArrayList<>();
        int[] counter = new int[45];
        for (int i = 0; i < 45; i++) {
            counter[i] = 0;
        }
        for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
            Row row = iterator.next();
            total += 1;
            //line += row.getString("tx_gabarito_ch") + "\n";
            char[] gabarito =  row.getString("tx_gabarito_" + msg[1]).toCharArray();
            char[] respostas =  row.getString("tx_respostas_" + msg[1]).toCharArray();
            if (gabarito.length == 45) {
                for (int i = 0; i < 45; i++) {
                    if (gabarito[i] == respostas[i])
                        counter[i] += 1;
                }
            }
        }
        for (int i = 0; i < 45; i++) {
            double p = 100 * ((double) counter[i] / (double) total);
            line += "Questão " + (i+1) + ": " + String.format("%.2f", p) + "% | ";
        }
        if (line.length() < 1){
            line = "Usuário não encontrado";
        }
        //line += calcActor.getAcertos(0);
        return line;
    }

    public String queryUF(ExamUFMsgQuery e) {

        ResultSet results = session.execute(
                "SELECT  tx_gabarito_"+ e.getExam() + ", tx_respostas_" + e.getExam() + " FROM provas WHERE uf_prova = \'"
                        + e.getUF() + "\' allow filtering");
        String line = "";
        int total = 0;
        ArrayList<Pair<String, String>> gabarito_resposta = new ArrayList<>();
        int[] counter = new int[45];
        for (int i = 0; i < 45; i++) {
            counter[i] = 0;
        }
        for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
            Row row = iterator.next();
            total += 1;
            //line += row.getString("tx_gabarito_ch") + "\n";
            char[] gabarito =  row.getString("tx_gabarito_" + e.getExam()).toCharArray();
            char[] respostas =  row.getString("tx_respostas_" + e.getExam()).toCharArray();
            if (gabarito.length == 45) {
                for (int i = 0; i < 45; i++) {
                    if (gabarito[i] == respostas[i])
                        counter[i] += 1;
                }
            }
        }
        for (int i = 0; i < 45; i++) {
            double p = 100 * ((double) counter[i] / (double) total);
            line += "Questão " + (i+1) + ": " + String.format("%.2f", p) + "% | ";
        }
        if (line.length() < 1){
            line = "Usuário não encontrado";
        }
        //line += calcActor.getAcertos(0);
        return line;
    }
    static public Props props() {
        return Props.create(DbActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s -> {
                    sender().tell(queryCity(s), self());
                })
                .match(Long.class, s -> {
                    sender().tell(queryUser(s), self());
                })
                .match(ExamUFMsgQuery.class, e -> {
                    sender().tell(queryUF(e), self());
                })
                .build();
    }

}
