package graphs

import java.util.*

fun main() {
    // nodes
    val socks = Node("Носки");
    val boots = Node("Туфли")
    val underwear = Node("Трусы")
    val trousers = Node("Брюки")
    val watch = Node("Часы")
    val belt = Node("Ремень")
    val tie = Node("Галстук")
    val suit = Node("Пиджак")
    val shirt = Node("Рубашка")

    // graph
    val graph = mapOf(
        underwear to listOf(boots, trousers),
        socks to listOf(boots),
        watch to listOf(),
        boots to listOf(),
        trousers to listOf(belt),
        belt to listOf(suit),
        shirt to listOf(belt,tie),
        suit to listOf(),
        tie to listOf(shirt)
    )

    val topologicalSort = topologicalSort(graph)
    println(topologicalSort)
}


fun topologicalSort(
    graph: Map<Node, List<Node>>,
    ordered: LinkedList<Node> = LinkedList<Node>()
): LinkedList<Node> {
    val nodes = graph.keys
    for (n in nodes) {
        if (!n.visited) {
            blackMagic(n, graph, ordered)
        }
    }

    return ordered
}

fun blackMagic(node: Node, graph: Map<Node, List<Node>>, ordered: LinkedList<Node>) {
    node.visited = true

    for (neigh in graph[node]!!) {
        if (!neigh.visited) blackMagic(neigh, graph, ordered)
    }

    ordered.addFirst(node)
}
