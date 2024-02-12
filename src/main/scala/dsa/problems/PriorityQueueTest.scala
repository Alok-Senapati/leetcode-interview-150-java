package dsa.problems

import scala.collection.mutable

object PriorityQueueTest extends App {
//  implicit val ordering: Ordering[Int] = Ordering.fromLessThan(_ < _)
  val pq: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
  pq.addOne(3)
  pq.addOne(2)
  pq.addOne(9)
  pq.addOne(5)
  pq.addOne(7)

  while (!pq.isEmpty) {
    println(pq.dequeue())
  }
  println(Math.ceil(3 / 2.0).toInt)
  val s: String = "Alok"
  println(s.head)
  println(s.tail)
}
