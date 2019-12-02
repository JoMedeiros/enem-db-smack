// @GENERATOR:play-routes-compiler
// @SOURCE:/home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/conf/routes
// @DATE:Mon Dec 02 13:27:01 BRT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:16
  class ReverseMasterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def selectAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "selectall")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sayHi(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hi/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:11
    def requestUser(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "requestinfo/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:7
    def sayHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
    // @LINE:12
    def requestCity(nameexam:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cidade/" + implicitly[play.api.mvc.PathBindable[String]].unbind("nameexam", nameexam))
    }
  
    // @LINE:19
    def sparkHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "spark")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:13
    def requestUF(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "estado/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
  }


}
