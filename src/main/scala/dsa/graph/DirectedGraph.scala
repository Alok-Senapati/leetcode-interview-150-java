package dsa.graph

class DirectedGraph[T](edgeMap: Map[T, Set[T]]) extends Graph[T](edgeMap) {
  override def nodes: List[T] = edgeMap.keys.toList

  override def edges: List[(T, T)] = {
    edgeMap.flatMap {
      case (source, target) => target.map((source, _))
    }.toList
  }

  override def addNode(node: T): DirectedGraph[T] = new DirectedGraph[T](edgeMap + (node -> Set.empty))
  
  override def addNodes(nodes: List[T]): DirectedGraph[T] = nodes.foldRight(this)((node, graph) => graph.addNode(node))

  override def addEdge(source: T, target: T): DirectedGraph[T] = new DirectedGraph[T](edgeMap + (source -> (edgeMap(source) + target)))

  override def neighbours(node: T): List[T] = edgeMap(node).toList
}

object DirectedGraph {
  def apply[T](edgeMap: Map[T, Set[T]] = Map.empty[T, Set[T]]): DirectedGraph[T] = new DirectedGraph[T](edgeMap)
}