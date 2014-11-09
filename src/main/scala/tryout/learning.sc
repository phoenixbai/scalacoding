import proinscala.chap4._

val acc = new ChecksumAccumulator
acc.add("1".toByte)
println("1".toByte)

val sum = acc.sum
println(~(sum & 0xFF))

println(~(sum & 0xFF) + 1)

acc.checksum()