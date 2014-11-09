package proinscala.chap6

import math.abs

/**
 * Created by phoenix on 11/9/14.
 */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(abs(n), abs(d))
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  //auxiliary constructor
  override def toString = numer + "/" + denom

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - denom * that.numer, denom * that.denom)

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  def lessThan(that: Rational) =
    numer * that.denom < denom * that.numer

  def max(that: Rational) =
    if (lessThan(that)) that
    else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}
