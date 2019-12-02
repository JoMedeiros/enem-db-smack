package controllers;

import akka.actor.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;
import actors.*;
import messages.*;
import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    final ActorSystem actorSystem = ActorSystem.create("playakka");
    final ActorRef helloActor = actorSystem.actorOf(HelloActor.props());
    final ActorRef sparkActor = actorSystem.actorOf(SparkActor.props());
    final ActorRef dbActor = actorSystem.actorOf(DbActor.props());


    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> sayHello() {
          return FutureConverters.toJava(
              ask(helloActor, "Hello User", 2000))
                  .thenApply(response -> ok(views.html.actor.render(response.toString())));
    }

    public CompletionStage<Result> sayHi(String name) {
          return FutureConverters.toJava(
              ask(helloActor, "Hi "+name, 2000))
                  .thenApply(response -> ok(views.html.actor.render(response.toString())));
    }

    public CompletionStage<Result> sparkHello() {
          return FutureConverters.toJava(
              ask(sparkActor, "Hi ", 2000))
                  .thenApply(response -> ok(views.html.actor.render(response.toString())));
    }


    // Uncomment the code below for running without Cassandra (*AND UNCOMMENT THE RESPECTIVE ROUTE)
    public CompletionStage<Result> requestUser(String name) {
          return FutureConverters.toJava(
              ask(dbActor, Long.parseLong(name), 2000))
                  .thenApply(response -> ok(views.html.actor.render(response.toString())));
    }

    public CompletionStage<Result> requestCity(String city) {
        String cidade = "Provas realizadas em " + city.split("_")[0] + " ";
        String page_title = "Questões de ";
        String code = city.split("_")[1].toLowerCase();
        if (code.equals("cn"))
            page_title += "Ciências da Natureza";
        else if (code.equals("ch"))
            page_title += "Ciênicas Humanas";
        else if (code.equals("mt"))
            page_title += "Matemática";

        final String title = cidade + " - " + page_title;

        return FutureConverters.toJava(
                ask(dbActor, city, 20000))
                .thenApply(response -> ok(views.html.resultado.render(title, response.toString())));
    }

    public CompletionStage<Result> requestUF(String uf) {
        String UF = "Provas realizadas em " + uf.split("_")[0] + " ";
        String page_title = "Questões de ";
        String code = uf.split("_")[1].toLowerCase();
        if (code.equals("cn"))
            page_title += "Ciências da Natureza";
        else if (code.equals("ch"))
            page_title += "Ciênicas Humanas";
        else if (code.equals("mt"))
            page_title += "Matemática";

        final String title = UF + " - " + page_title;
        ExamUFMsgQuery eUFmq = new ExamUFMsgQuery(uf.split("_")[1], uf.split("_")[0]);

        return FutureConverters.toJava(
                ask(dbActor, eUFmq, 20000))
                .thenApply(response -> ok(views.html.resultado.render(title, response.toString())));
    }
}
