// @GENERATOR:play-routes-compiler
// @SOURCE:/home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/conf/routes
// @DATE:Mon Dec 02 13:27:01 BRT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:16
  class ReverseMasterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def selectAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MasterController.selectAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "selectall"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sayHi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHi",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hi/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
    // @LINE:11
    def requestUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.requestUser",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "requestinfo/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
    // @LINE:7
    def sayHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
    // @LINE:12
    def requestCity: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.requestCity",
      """
        function(nameexam0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cidade/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("nameexam", nameexam0)})
        }
      """
    )
  
    // @LINE:19
    def sparkHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sparkHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spark"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:13
    def requestUF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.requestUF",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "estado/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
  }


}
