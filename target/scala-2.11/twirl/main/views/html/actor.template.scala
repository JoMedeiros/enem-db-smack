
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object actor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(nome: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Page Title")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    """),format.raw/*4.5*/("""<p>"""),_display_(/*4.9*/nome),format.raw/*4.13*/("""</p>
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(nome:String): play.twirl.api.HtmlFormat.Appendable = apply(nome)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (nome) => apply(nome)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Dec 02 12:39:53 BRT 2019
                  SOURCE: /home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/app/views/actor.scala.html
                  HASH: 288e31a764cae738bf847ff4b73068972278c6ce
                  MATRIX: 948->1|1056->16|1083->18|1109->36|1148->38|1179->43|1208->47|1232->51|1267->57
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5
                  -- GENERATED --
              */
          