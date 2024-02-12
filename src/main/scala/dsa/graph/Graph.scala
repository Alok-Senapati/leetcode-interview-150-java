package dsa.graph

import scala.annotation.tailrec
import scala.collection.immutable.Queue

trait Graph[T](edgeMap: Map[T, Set[T]]) {
  def nodes: List[T]
  def edges: List[(T, T)]
  def addEdge(source: T, target: T): Graph[T]
  def addNode(node: T): Graph[T]
  def addNodes(node: List[T]): Graph[T]
  def neighbours(node: T): List[T]

  override def toString: String = {
    edgeMap.map {
      case(node, neighbours) => s"$node -> ${neighbours.mkString("(", ", ", ")")}"
    }.mkString("\n")
  }
}

object Graph {
  def bfs[T](graph: Graph[T], src: T): String = {
    @tailrec
    def bfsHelper(queue: Queue[T], acc: String, isVisited: Map[T, Boolean]): String = {
      if queue.isEmpty then {
        val remainingNodes = isVisited.filter(!_._2)
        if remainingNodes.isEmpty then acc.trim
        else bfsHelper(queue :+ remainingNodes.head._1, acc, isVisited)
      }
      else if isVisited.getOrElse(queue.head, true) then bfsHelper(queue.tail, acc, isVisited)
      else bfsHelper(graph.neighbours(queue.head).foldRight(queue.tail)((t, q) => q :+ t), s"$acc ${queue.head}" , isVisited + (queue.head -> true))
    }

    val isVisited: Map[T, Boolean] = graph.nodes.foldRight(Map.empty[T, Boolean])((n, m) => m + (n -> false))
    val queue = Queue(src)
    bfsHelper(queue, "", isVisited)
  }

  def dfs[T](graph: Graph[T], src: T): String = {
    @tailrec
    def dfsHelper(stack: List[T], acc: String, isVisited: Map[T, Boolean]): String = {
      if stack.isEmpty then {
        val remainingNodes = isVisited.filter(!_._2)
        if remainingNodes.isEmpty then acc.trim
        else dfsHelper(remainingNodes.head._1 :: stack, acc, isVisited)
      }
      else if isVisited.getOrElse(stack.head, true) then dfsHelper(stack.tail, acc, isVisited)
      else dfsHelper(graph.neighbours(stack.head).foldRight(stack.tail)((t, s) => t :: s), s"$acc ${stack.head}", isVisited + (stack.head -> true))
    }

    val isVisited: Map[T, Boolean] = graph.nodes.foldRight(Map.empty[T, Boolean])((n, m) => m + (n -> false))
    val stack = List(src)
    dfsHelper(stack, "", isVisited)
  }

  def isCyclic[T](graph: Graph[T]): Boolean = {
    @tailrec
    def isCyclicHelper(stack: List[(T, Option[T])], isVisited: Map[T, Boolean]): Boolean = {
      if stack.isEmpty then {
        val remainingNodes = isVisited.filter(!_._2)
        if remainingNodes.isEmpty then false
        else isCyclicHelper((remainingNodes.head._1, None) :: stack, isVisited)
      } else if isVisited.getOrElse(stack.head._1, true) then true
      else isCyclicHelper(graph.neighbours(stack.head._1).filter(node => node != stack.head._2.getOrElse(null)).foldLeft(stack.tail)((s, t) => (t, Some(stack.head._1)) :: s), isVisited.updated(stack.head._1, true))
    }
    val isVisited: Map[T, Boolean] = graph.nodes.foldRight(Map.empty[T, Boolean])((n, m) => m + (n -> false))
    val stack: List[(T, Option[T])] = List((graph.nodes.head, None))
    isCyclicHelper(stack, isVisited)
  }
}