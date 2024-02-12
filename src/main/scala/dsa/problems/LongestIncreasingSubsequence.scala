package dsa.problems

object LongestIncreasingSubsequence extends App {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val memo: Array[Int] = Array.fill(nums.length)(0)

    def smallerThanN(n: Int, memo: Map[Int, Int], maxList: Int): Int = {
      if (memo.isEmpty) maxList
      else if (nums(memo.head._1) < n) smallerThanN(n, memo.tail, Math.max(maxList, memo.head._2))
      else smallerThanN(n, memo.tail, maxList)
    }

    def lisHelper(i: Int, memo: Map[Int, Int]): Int = {
      if (i >= nums.length) memo.values.max
      else {
        val lisLessThanN = smallerThanN(nums(i), memo, 0) + 1
        println(s"$i -> ${nums(i)} -> $memo -> $lisLessThanN")
        lisHelper(i + 1, memo.updated(i, lisLessThanN))
      }
    }

    lisHelper(0, Map[Int, Int]())
  }

  lengthOfLIS(List(10,9,2,5,3,7,101,18).toArray)
}
