package dsa.problems

class MinStack {
  var s: List[(Int, Int)] = List()

  def push(`val`: Int): Unit = {
    if (s.isEmpty || `val` < s.head._2) s = (`val` -> `val`) :: s
    else s = (`val` -> s.head._2) :: s
  }

  def pop(): Unit = {
    s = s.tail
  }

  def top(): Int = {
    s.head._1
  }

  def getMin(): Int = {
    s.head._2
  }
}
