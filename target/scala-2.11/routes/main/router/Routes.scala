// @GENERATOR:play-routes-compiler
// @SOURCE:/home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/conf/routes
// @DATE:Mon Dec 02 13:27:01 BRT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:16
  MasterController_0: controllers.MasterController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:16
    MasterController_0: controllers.MasterController
  ) = this(errorHandler, HomeController_1, MasterController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, MasterController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HomeController.sayHello()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hi/""" + "$" + """name<.+>""", """controllers.HomeController.sayHi(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requestinfo/""" + "$" + """name<.+>""", """controllers.HomeController.requestUser(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cidade/""" + "$" + """nameexam<.+>""", """controllers.HomeController.requestCity(nameexam:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """estado/""" + "$" + """name<.+>""", """controllers.HomeController.requestUF(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """selectall""", """controllers.MasterController.selectAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """spark""", """controllers.HomeController.sparkHello()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_sayHello1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_HomeController_sayHello1_invoker = createInvoker(
    HomeController_1.sayHello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sayHello",
      Nil,
      "GET",
      this.prefix + """hello""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_sayHi2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hi/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_sayHi2_invoker = createInvoker(
    HomeController_1.sayHi(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sayHi",
      Seq(classOf[String]),
      "GET",
      this.prefix + """hi/""" + "$" + """name<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_requestUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requestinfo/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_requestUser3_invoker = createInvoker(
    HomeController_1.requestUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "requestUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """requestinfo/""" + "$" + """name<.+>""",
      """# Uncomment the route below for running without Cassandra""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_requestCity4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cidade/"), DynamicPart("nameexam", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_requestCity4_invoker = createInvoker(
    HomeController_1.requestCity(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "requestCity",
      Seq(classOf[String]),
      "GET",
      this.prefix + """cidade/""" + "$" + """nameexam<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_requestUF5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("estado/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_requestUF5_invoker = createInvoker(
    HomeController_1.requestUF(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "requestUF",
      Seq(classOf[String]),
      "GET",
      this.prefix + """estado/""" + "$" + """name<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_MasterController_selectAll6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("selectall")))
  )
  private[this] lazy val controllers_MasterController_selectAll6_invoker = createInvoker(
    MasterController_0.selectAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MasterController",
      "selectAll",
      Nil,
      "GET",
      this.prefix + """selectall""",
      """ Example of supervision+routing""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_sparkHello7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("spark")))
  )
  private[this] lazy val controllers_HomeController_sparkHello7_invoker = createInvoker(
    HomeController_1.sparkHello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sparkHello",
      Nil,
      "GET",
      this.prefix + """spark""",
      """ Spark test""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index())
      }
  
    // @LINE:7
    case controllers_HomeController_sayHello1_route(params@_) =>
      call { 
        controllers_HomeController_sayHello1_invoker.call(HomeController_1.sayHello())
      }
  
    // @LINE:8
    case controllers_HomeController_sayHi2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_sayHi2_invoker.call(HomeController_1.sayHi(name))
      }
  
    // @LINE:11
    case controllers_HomeController_requestUser3_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_requestUser3_invoker.call(HomeController_1.requestUser(name))
      }
  
    // @LINE:12
    case controllers_HomeController_requestCity4_route(params@_) =>
      call(params.fromPath[String]("nameexam", None)) { (nameexam) =>
        controllers_HomeController_requestCity4_invoker.call(HomeController_1.requestCity(nameexam))
      }
  
    // @LINE:13
    case controllers_HomeController_requestUF5_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_requestUF5_invoker.call(HomeController_1.requestUF(name))
      }
  
    // @LINE:16
    case controllers_MasterController_selectAll6_route(params@_) =>
      call { 
        controllers_MasterController_selectAll6_invoker.call(MasterController_0.selectAll())
      }
  
    // @LINE:19
    case controllers_HomeController_sparkHello7_route(params@_) =>
      call { 
        controllers_HomeController_sparkHello7_invoker.call(HomeController_1.sparkHello())
      }
  }
}
