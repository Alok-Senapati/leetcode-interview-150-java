package dsa.problems

object Triangle extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val m = triangle.length
    val n = triangle.last.length
    val dp: Array[Array[Int]] = Array.fill(m, n)(Int.MinValue)
    for (j <- 0 to n - 1) {
      dp(m - 1)(j) = triangle(m - 1)(j)
    }

    for {
      i <- m - 2 to 0 by -1
      j <- i to 0 by -1
    } dp(i)(j) = triangle(i)(j) + Math.min(dp(i + 1)(j), dp(i + 1)(j + 1))

    dp(0)(0)
  }
  minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3)))
}
