package proinscala.chap4

import proinscala.chap4.ChecksumAccumulator.calculate
/**
 * Created by phoenix on 11/8/14.
 */
object Summer {
  def main(args: Array[String]){
    for(arg <- args)
      println(arg + ": " + calculate(arg))
  }
}
