package tryout

import java.util.StringTokenizer
import scala.collection.mutable.{ListBuffer, ArrayBuffer}

/**
 * Created by phoenix on 10/20/14.
 */
object Parser {
  def main(args: Array[String]) {
    parse("(1,[2,3,4,58432,423.34])")
    parse("34[12,34,11](3,2,4)")

  }
  def parse(s: String) {
    val tokenizer = new StringTokenizer(s, "[](),", true)
    if (tokenizer.hasMoreTokens) {
      val token = tokenizer.nextToken()
      println(s"token is: $token, tokenizer is:" + tokenizer.toString)
      if (token == "(")
//        println("parsing tuple!")
        parseTuple(tokenizer)
      else if (token == "[")
//        println("parsing array!")
        parseArray(tokenizer)
      else
//        println("parsing double!")
        parseDouble(token)
    } else {
      throw new Exception(s"Cannot find any token from the input string.")
    }
  }
  private def parseArray(tokenizer: StringTokenizer): Array[Double] = {
    val values = ArrayBuffer.empty[Double]
    var parsing = true
    var allowComma = false
    var token: String = null
    while (parsing && tokenizer.hasMoreTokens) {
      token = tokenizer.nextToken()
      println(s"token in parseArray: $token")
      if (token == "]") {
        parsing = false
      } else if (token == ",") {
        if (allowComma) {
          allowComma = false
        } else {
          throw new Exception("Found a ',' at a wrong position.")
        }
      } else {
        // expecting a number
        values.append(parseDouble(token))
        allowComma = true
      }
    }
    if (parsing) {
      throw new Exception(s"An array must end with ']'.")
    }
    values.toArray
  }

  private def parseTuple(tokenizer: StringTokenizer): Seq[_] = {
    val items = ListBuffer.empty[Any]
    var parsing = true
    var allowComma = false
    var token: String = null
    while (parsing && tokenizer.hasMoreTokens) {
      token = tokenizer.nextToken()
      println(s"token in parseTuple: $token")
      if (token == "(") {
        items.append(parseTuple(tokenizer))
        allowComma = true
      } else if (token == "[") {
        items.append(parseArray(tokenizer))
        allowComma = true
      } else if (token == ",") {
        if (allowComma) {
          allowComma = false
        } else {
          throw new Exception("Found a ',' at a wrong position.")
        }
      } else if (token == ")") {
        parsing = false
      } else {
        // expecting a number
        items.append(parseDouble(token))
        allowComma = true
      }
    }
    if (parsing) {
      throw new Exception(s"A tuple must end with ')'.")
    }
    items
  }

  private def parseDouble(s: String): Double = {
    try {
      java.lang.Double.parseDouble(s)
    } catch {
      case e: Throwable =>
        throw new Exception(s"Cannot parse a double from: $s", e)
    }
  }
}
