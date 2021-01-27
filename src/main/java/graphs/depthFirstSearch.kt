package graphs

fun main() {
    // nodes
    val A = Node("A");
    val B = Node("B")
    val C = Node("C")
    val D = Node("D")
    val E = Node("E")

    // graph
    val graph = mapOf(
        A to listOf(B, C),
        B to listOf(A, C),
        C to listOf(A, B, D, E),
        D to listOf(C, E),
        E to listOf(C, D)
    )

    depthFirstSearch(A, graph)
}

class Node(val name: String) {
    var visited = false
}


fun depthFirstSearch(node: Node, graph: Map<Node, List<Node>>) {
    node.visited = true
    println("node ${node.name} is visited")
    val neighbors = graph[node]!!
    for (neighbor in neighbors) {
        if (!neighbor.visited) depthFirstSearch(neighbor, graph)
    }
}