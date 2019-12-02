package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.Pair;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class SparkCalcActor extends AbstractActor {

	public Integer num = 0;
	private JavaRDD<Pair<String, String>> gabarito_respostaRDD;

	public SparkCalcActor(List<Pair<String, String>> gabarito_resposta) {
		System.out.println("==================================================\n\tSpark Actor will be created");
		SparkConf conf = new SparkConf(true)//
				.setAppName("MyApp")//
				.setMaster("spark://pop-os.localdomain:7077");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<Integer> numbers = sc.parallelize(Arrays.asList(14,21,88,99,455));
		this.gabarito_respostaRDD = sc.parallelize( gabarito_resposta );
		//gabarito_respostaRDD.filter(s ->
		//		s.first().charAt(0) == s.second().charAt(0)).count();

		num = numbers.first();
		//sc.close();

	}

	public long getAcertos(int Q){
		return gabarito_respostaRDD.filter(s ->
				s.first().charAt(Q) == s.second().charAt(Q)).count();
	}

	static public Props props() {
		return Props.create(SparkCalcActor.class);
	}




	@Override
	public Receive createReceive() {
		return receiveBuilder()//
				.match(String.class, s -> {
					sender().tell(s+", I'm an actor using Spark! The first element of the RDD is "+ String.valueOf(num), self());
				})
				.build();
	}
}
