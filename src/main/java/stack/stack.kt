package stack

fun main() {
    val stack = Stack()
    stack.push(1)
    stack.push(2)
    println(stack)
}
class Stack {
    private var top:Int = -1
    private val storage = Array<Int> (5) {0}


    fun isEmpty(): Boolean {
        return storage.isEmpty()
    }

    fun push(el: Int) {
        if (top >= storage.size) throw UnsupportedOperationException()
        top++
        storage[top] = el
    }

    fun pop():Int {
        if (top == -1) throw UnsupportedOperationException()
        return storage[top--]
    }

    override fun toString(): String {
        var r = ""
        for (i in storage.iterator()) {
            r += "$i, "
        }
        return r
    }
}
