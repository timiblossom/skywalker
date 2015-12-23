import scala.util.Random

object ListMinMax {
  def main(args: Array[String]) {

    println("==============================================")
    val list = Seq.fill(100)(Random.nextInt)
    println (list)

    val maxVal = (list foldLeft 0)(Math.max)
    println(maxVal)

    val minVal = (list foldLeft Integer.MAX_VALUE)(Math.min)
    println(minVal)

  }
}
