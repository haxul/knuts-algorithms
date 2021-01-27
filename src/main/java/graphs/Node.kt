package graphs

class Node(val name: String) {
    var visited = false

    override fun toString(): String {
        return name
    }
}
