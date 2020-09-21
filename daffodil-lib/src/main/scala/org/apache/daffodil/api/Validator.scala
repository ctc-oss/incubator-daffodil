package org.apache.daffodil.api

import org.xml.sax.ErrorHandler

trait Validator {
  def name(): String = getClass.getTypeName.toLowerCase

  def validateXMLSources(document: java.io.InputStream, errHandler: ErrorHandler): Unit
}

trait HasSchemaFiles {
  def schemaFileNames(fileNames: Seq[String]): Unit
}
