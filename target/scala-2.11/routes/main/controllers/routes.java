// @GENERATOR:play-routes-compiler
// @SOURCE:/home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/conf/routes
// @DATE:Mon Dec 02 13:27:01 BRT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMasterController MasterController = new controllers.ReverseMasterController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMasterController MasterController = new controllers.javascript.ReverseMasterController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
