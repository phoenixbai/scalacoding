package proinscala.chap6

/**
 * Created by phoenix on 11/9/14.
 */
class Chapter7Example {

  def withoutContinueVer1(args: Array[String]) {
    var i = 0
    var foundIt = false
    while (i < args.length && !foundIt) {
      if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala"))
          foundIt = true
      }
      i = i + 1
    }
  }

  def searchFrom(i: Int, args: Array[String]): Int =
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)

  val i = searchFrom(0)
}
