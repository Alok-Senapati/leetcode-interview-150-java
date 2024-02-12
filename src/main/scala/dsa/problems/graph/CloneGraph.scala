package dsa.problems.graph

object CloneGraph {

  def cloneGraph(graph: Node): Node = {
    var visited: Map[Int, Node] = Map()

    def cloneGraphHelper(graph: Node): Node = {
      if (graph == null) null
      else {
        val copiedGraph = new Node(graph._value)
        visited = visited.updated(graph.value, copiedGraph)
        copiedGraph.neighbors = graph.neighbors.foldLeft(List[Node]())((neighbours, node) =>
          neighbours :+ visited.getOrElse(node.value, cloneGraphHelper(node))
        )
        copiedGraph
      }
    }

    cloneGraphHelper(graph)
  }
}
