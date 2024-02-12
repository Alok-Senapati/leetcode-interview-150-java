package dsa.graph

class UndirectedGraph[T] (edgeMap: Map[T, Set[T]]) extends DirectedGraph[T](edgeMap) {
  override def addNode(node: T): UndirectedGraph[T] = new UndirectedGraph[T](edgeMap + (node -> Set[T]()))

  override def addEdge(source: T, target: T): UndirectedGraph[T] = {
    val sourceNeighbours = neighbours(source) :+ target
    val targetNeighbours = neighbours(target) :+ source
    new UndirectedGraph[T](edgeMap + (source -> sourceNeighbours.toSet) + (target -> targetNeighbours.toSet))
  }

  override def addNodes(nodes: List[T]): UndirectedGraph[T] = nodes.foldRight(this)((node, graph) => graph.addNode(node))
}

object UndirectedGraph {
  def apply[T](edgeMap: Map[T, Set[T]] = Map.empty[T, Set[T]]): UndirectedGraph[T] = new UndirectedGraph[T](edgeMap)
}
