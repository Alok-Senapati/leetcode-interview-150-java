package dsa.problems.graph

class Node (var _value: Int) {
  var value = _value
  var neighbors: List[Node] = List()
}
