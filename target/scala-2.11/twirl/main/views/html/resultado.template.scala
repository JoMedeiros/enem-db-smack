
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

object resultado extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titulo: String, nome: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Resultados")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    """),format.raw/*4.5*/("""<p>"""),_display_(/*4.9*/titulo),format.raw/*4.15*/(""": </p>
    <p>"""),_display_(/*5.9*/nome),format.raw/*5.13*/("""</p>
""")))}),format.raw/*6.2*/("""
"""))
      }
    }
  }

  def render(titulo:String,nome:String): play.twirl.api.HtmlFormat.Appendable = apply(titulo,nome)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (titulo,nome) => apply(titulo,nome)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Dec 02 13:42:33 BRT 2019
                  SOURCE: /home/work/Codes/concorrente/unidade3/examplo-de-aula-play-akka/app/views/resultado.scala.html
                  HASH: ecd71225bf575dfba07b39b8ad0726bf4937ee67
                  MATRIX: 959->1|1083->32|1110->34|1136->52|1175->54|1206->59|1235->63|1261->69|1301->84|1325->88|1360->94
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5|36->5|37->6
                  -- GENERATED --
              */
          