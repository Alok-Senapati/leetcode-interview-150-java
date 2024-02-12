package dsa.problems

object MergeArrays extends App {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    @scala.annotation.tailrec
    def mergeArrays(idx1: Int, idx2: Int, currIdx: Int): Unit = {
      if (currIdx < 0) {}
      else if (idx2 >= 0 && nums2(idx2) > nums1(idx1)) {
        nums1(currIdx) = nums2(idx2)
        mergeArrays(idx1, idx2 - 1, currIdx - 1)
      } else {
        nums1(currIdx) = nums1(idx1)
        mergeArrays(idx1 - 1, idx2, currIdx - 1)
      }
    }

    mergeArrays(m - 1, n - 1, m + n - 1)
  }

  val arr1 = Array[Int](1, 2, 3, 0, 0, 0)
  val arr2 = Array[Int](2, 5, 6)
  merge(arr1, 3, arr2, 3)
  println(arr1 mkString ", ")
}
