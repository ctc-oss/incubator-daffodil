package sch

import java.io.InputStream

import org.apache.daffodil.api.Validator
import org.xml.sax.ErrorHandler

class SchematronValidator extends Validator {
  override def name(): String = "sch"

  def validateXMLSources(document: InputStream, errHandler: ErrorHandler): Unit = {
    println("Boom!")
  }
}
