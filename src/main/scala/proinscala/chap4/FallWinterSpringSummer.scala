package proinscala.chap4

import proinscala.chap4.ChecksumAccumulator.calculate
/**
 * Created by phoenix on 11/8/14.
 */
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
