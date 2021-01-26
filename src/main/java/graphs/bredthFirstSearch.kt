package graphs

import java.util.*


fun main() {

    val graph = mapOf(
        "A" to listOf("B", "C"),
        "B" to listOf("A", "C"),
        "C" to listOf("A", "B", "D", "E"),
        "D" to listOf("C", "E"),
        "E" to listOf("C", "D")
    )

    val q = mutableListOf("A");
    search(graph, q)
}

fun search(graph:Map<String, List<String>>, q:MutableList<String>, checked:MutableMap<String,Boolean> = mutableMapOf()) {
    if (q.size == 0) return
    val element:String = q.removeFirst()
    if (checked[element] != null) return search(graph, q, checked)
    checked[element] = true
    println(element)
    q.addAll(graph[element]!!)
    return search(graph,q, checked)
}