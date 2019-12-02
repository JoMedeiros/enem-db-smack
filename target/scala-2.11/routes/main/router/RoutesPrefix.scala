// @GENERATOR:play-routes-compiler
// @SOURCE:/home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/conf/routes
// @DATE:Mon Dec 02 13:27:01 BRT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
