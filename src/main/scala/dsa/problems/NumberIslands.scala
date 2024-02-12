package dsa.problems

object NumberIslands extends App {
  def getNeighboursPart(node: (Int, Int), grid: Array[Array[Char]]): Set[(Int, Int)] = {
    var neighbours: Set[(Int, Int)] = Set[(Int, Int)]()
    for(i <- node._1 - 1 to node._1 + 1 if i >= 0 && i < grid.length && grid(i)(node._2) == '1') {
      neighbours = neighbours + (i -> node._2)
    }

    for (j <- node._2 - 1 to node._2 + 1 if j >= 0 && j < grid(0).length && grid(node._1)(j) == '1') {
      neighbours = neighbours + (node._1 -> j)
    }
    neighbours
  }

  def dfs(node: (Int, Int), grid: Array[Array[Char]]): Unit = {
    if (grid(node._1)(node._2) == '0') ()
    else {
      grid(node._1)(node._2) = 0
      val neighbours = getNeighboursPart(node, grid)
        neighbours.foreach(n => dfs(n, grid))
    }
  }

  def numIslands(grid: Array[Array[Char]]): Int = {
    var count = 0
    for {
      i <- 0 until grid.length
      j <- 0 until grid(i).length
    } {
      if (grid(i)(j) == '1') {
        count = count + 1
        dfs((i, j), grid)
      }
    }
    count
  }

  val grid = Array(
    Array('1', '1', '0'),
    Array('1', '0', '1'),
    Array('0', '1', '1')
  )
  println(getNeighboursPart((1, 2), grid))
  println(numIslands(grid))
}
