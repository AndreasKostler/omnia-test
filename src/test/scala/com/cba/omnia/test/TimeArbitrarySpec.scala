package com.cba.omnia.test

import org.joda.time._

import com.github.nscala_time.time.Imports._

object TimeArbitrarySpec extends Spec { def is = s2"""
TimeArbitraries
===============

ArbitraryDateTime should:
  generate and produce a useable value            $dateTime

ArbitraryLocalDate should:
  generate and produce a useable value            $localDate

"""

  import TimeArbitrary._

  def dateTime = prop((date: DateTime) => {
    date.plus(1.months).toInstant; date.getYear; ok
  })

  def localDate = prop((date: LocalDate) => {
    date.plus(1.months).toInterval; date.getYear; ok
  })
}
