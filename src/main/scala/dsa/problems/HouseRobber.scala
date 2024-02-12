package dsa.problems

object HouseRobber extends App {
  def rob(nums: Array[Int]): Int = {
    def helper(nums: Array[Int], lastHouse: Int, prevLastHouse: Int): Int = {
      if (nums.isEmpty) lastHouse
      else helper(nums.tail, Math.max(lastHouse, prevLastHouse + nums.head), lastHouse)
    }

    if (nums.length == 1) nums(0)
    else if (nums.length == 2) nums.max
    else helper(nums.tail.tail, Math.max(nums.tail.head, nums.head), nums.head)
  }
  println(rob(Array(2, 1, 1, 2)))
}
