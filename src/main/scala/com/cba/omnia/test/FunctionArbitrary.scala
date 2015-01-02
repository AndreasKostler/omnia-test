package com.cba.omnia.test

import org.scalacheck._

object FunctionArbitrary extends FunctionArbitrary

trait FunctionArbitrary {
  implicit def Function1DoubleDouble[A](implicit A: Arbitrary[Double]): Arbitrary[Double => Double] =
    Arbitrary(Gen.frequency[Double => Double](
      (1, Gen.const((x: Double) => x)),
      (1, Gen.const((x: Double) => x + 1.0)),
      (3, A.arbitrary.map(a => (_: Double) => a))
    ))

  implicit def Function1StringString[A](implicit A: Arbitrary[String]): Arbitrary[String => String] =
    Arbitrary(Gen.frequency[String => String](
      (1, Gen.const((x: String) => x)),
      (1, Gen.const((x: String) => x ++ "abc")),
      (3, A.arbitrary.map(a => (_: String) => a))
    ))
}
