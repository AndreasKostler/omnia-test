package com.cba.omnia.test

import org.specs2.{ScalaCheck, Specification}
import org.specs2.matcher.ThrownExpectations

abstract class OmniaSpec extends Specification with ThrownExpectations with ScalaCheck

object AllArbitraries extends FunctionArbitrary with TimeArbitrary
