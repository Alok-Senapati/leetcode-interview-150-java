package dsa.problems.graph

object CourseSchedule extends App {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val graph: Array[List[Int]] = prerequisites
      .foldLeft(Array.fill(numCourses)(List.empty[Int]))((g, e) => g.updated(e(0), g(e(0)) :+ e(1)))

    val isVisited: Map[Int, Boolean] = (0 until numCourses).foldLeft(Map[Int, Boolean]())((m, n) => m + (n -> false))
    val stack: List[(Int, Option[Int])] = List((0, None))

    def dfs(stack: List[(Int, Option[Int])], isVisited: Map[Int, Boolean], noNeighbourNodes: Set[Int]): Boolean = {
      if stack.isEmpty then {
        val remainingNodes = isVisited.filter(n => !n._2 && !noNeighbourNodes.contains(n._1))
        if remainingNodes.isEmpty then true
        else dfs((remainingNodes.head._1, None) :: stack, isVisited, noNeighbourNodes)
      }
      else if isVisited(stack.head._1) then false
      else if stack.head._2 == None && graph(stack.head._1).isEmpty then
        dfs(stack.tail, isVisited, noNeighbourNodes + stack.head._1)
      else
        dfs(graph(stack.head._1)
            .foldLeft(stack.tail)((s, t) => (t, Some(stack.head._1)) :: s),
          isVisited.updated(stack.head._1, true), noNeighbourNodes)
    }

    dfs(stack, isVisited, Set.empty[Int])
  }

  println(canFinish(2, Array(Array(1, 0), Array(1, 0))))
  println(Set().size)
  println(Set() + 1)

}
