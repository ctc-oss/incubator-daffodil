package org.apache.daffodil.util

import java.util.ServiceLoader

import org.apache.daffodil.api.Validator

object Validators {
  import scala.collection.JavaConverters._

  private val impls = new ThreadLocal[Map[String, Validator]] {
    override def initialValue = {
        ServiceLoader
          .load(classOf[Validator])
          .iterator()
          .asScala
          .map(v => v.name() -> v)
          .toMap
    }
  }

  def all(): Map[String, Validator] = impls.get()
  def get(name: String): Option[Validator] = all().get(name)
  def exists(name: String): Boolean =
    all().exists(name == _._1)
  def default(): Validator = new DefaultValidatorSPIProvider
}
