//package coursera.progfun
//
//import scala.annotation.tailrec
//
///**
// * Created by phoenix on 9/28/14.
// */
//object TestFunction {
//  def main(args:Array[String]) {
//    val t = new TestFunction
//    println(t.sqrt(4))
//    println(t.sqrt(1e3))
//  }
//}
//
//class TestFunction {
//
//  def sqrt(x: Double): Double = {
//
//    def sqrtIter(guess: Double): Double = {
//      if (isGoodEnough(guess: Double)) guess
//      else sqrtIter(improve(guess))
//    }
//
//    def isGoodEnough(guess: Double): Boolean = {
//      abs(guess * guess - x) / x < 0.001
//    }
//
//    def improve(guess: Double): Double = {
//      (guess + x / guess) / 2
//    }
//
//    def abs(y: Double) = if (y < 0) -y else y
//
//    sqrtIter(1.0)
//  }
//  /*
//    gcd => greatest common divisor
//    tail recursion : if a function calls itself as its last action,
//                    the function`s stack frame can be reused, this is called tail recursion.
//                    tail recursive functions are iterative processes.
//   */
////  @tailrec
//  def gcd(a: Int, b: Int): Int = {
//    if (b == 0) a
//    else gcd(b, a % b)
//  }
//  /*
//    factorial is not a tail recursion function, before factorial itself is not the last call
//    it still need to do multiplication after factorial call on itself.
//   */
//  def factorial(n: Int): Int =
//    if (n == 0) 1 else factorial(n - 1) * n
//
//  def factorialInTailRec(n: Int): Int = {
//    def loop(acc: Int, n:Int): Int =
//      if (n == 0) acc
//      else loop(acc*n, n - 1)
//
//    loop(1, n)
//  }
//
//  /*
//    finding fixed points
//   */
//  def fixedPoint(f:Double => Double)(firstGuess: Double) = {
//    val tolerance = 0.0001
//    def isCloseEnough(x: Double, y: Double) =
//      abs((x - y) / x) / x < tolerance
//
//    def iterate(guess: Double): Double = {
//      val next = f(guess)
//      if(isCloseEnough(guess, next)) next
//      else iterate(next)
//    }
//    iterate(firstGuess)
//  }
//  fixedPoint(x => 1 + x/2)(1)
//  def sqrtAlt1(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
//  def sqrtAlt2(x: Double) = fixedPoint(y => (x / y) / 2)(1.0) //never ends
//
//  /*
//    the iteration in sqrtAlt1 converges by averaging successive values
//    this technique of stabilizing by averaging is general enough to merit
//    being abstracted into its own function
//   */
//  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
//
//  def sqrtAlt3(x: Double) =
//    fixedPoint(averageDamp(y => x / y)(1))
//  sqrt(2)
//}