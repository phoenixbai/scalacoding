package proinscala.chap4

/**
 * Created by phoenix on 11/8/14.
 */
import scala.collection.mutable.Map
object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}
class ChecksumAccumulator {
  var sum = 0
  def add(b: Byte) { sum += b}
  //def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}

