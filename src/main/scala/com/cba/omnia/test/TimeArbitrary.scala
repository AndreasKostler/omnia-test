package com.cba.omnia.test

import org.joda.time._
import org.scalacheck._

object TimeArbitrary extends TimeArbitrary

trait TimeArbitrary {
  implicit lazy val ArbitraryDateTime: Arbitrary[DateTime] =
    Arbitrary(Gen.posNum[Long].map(new DateTime(_)))

  implicit def Function1DateTimeDateTime[A](implicit A: Arbitrary[DateTime]): Arbitrary[DateTime => DateTime] =
    Arbitrary(Gen.frequency[DateTime => DateTime](
      (1, Gen.value((x: DateTime) => x)),
      (1, Gen.value((x: DateTime) => x plus 5)),
      (3, A.arbitrary.map(a => (_: DateTime) => a))
    ))

 implicit lazy val ArbitraryLocalDate: Arbitrary[LocalDate] =
   Arbitrary(for {
     year  <- Gen.choose(1900, 2100)
     month <- Gen.choose(1, 12)
     day   <- month match {
       case 2                           => Gen.choose(1, 28)
       case 1 | 3 | 5 | 7 | 8 | 10 | 12 => Gen.choose(1, 31)
       case _                           => Gen.choose(1, 30)
     }
   } yield new LocalDate(year, month, day))
}
