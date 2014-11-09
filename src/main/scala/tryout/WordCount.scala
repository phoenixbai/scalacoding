package tryout

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by phoenix on 11/8/14.
 */
object WordCount {
  def main(args: Array[String]){
    val logFile = "/home/phoenix/workspace/gitlab/Bakuto.scala"
    val conf = new SparkConf().setAppName("Word Count application!")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line=> line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))

  }
}
