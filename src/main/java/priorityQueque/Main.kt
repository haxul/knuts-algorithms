package priorityQueque

fun main() {

}

fun heapMaximum(xs: List<Int>): Int {
    return xs[0]
}

fun heapExtractMax(xs: MutableList<Int>, heapSize: Int): Int {
    if (xs.isEmpty()) throw UnsupportedOperationException()
    val max = xs[0]
    xs[0] = xs[heapSize - 1]
    val size = heapSize - 1
    maxHeapify(xs, 0, size)
    return max
}


fun maxHeapify(A: MutableList<Int>, i: Int, heapSize: Int) {
    val l = left(i)
    val r = right(i)
    var largest: Int

    largest = if (l < heapSize && A[l] > A[i]) l else i // if left children is more than parent
    if (r < heapSize && A[r] > A[largest]) largest = r
    if (largest != i) {
        A[i] = A[largest].also { A[largest] = A[i] }
        maxHeapify(A, largest, heapSize)
    }
}

fun heapIncreaseKey(list: MutableList<Int>, i: Int, key:Int) {
    if (key < list[i]) throw UnsupportedOperationException()
    list[i] = key
    var index = i
    while (index > 0 && list[parent(index)] < list[index]) {
        list[index] = list[parent(index)].also { list[parent(index)] = list[index]}
        index = parent(index)
    }
}

fun maxHeapInsert(list: MutableList<Int>, size:Int, key: Int) {
    list.add(0)
    heapIncreaseKey(list,size + 1, key)
}

fun parent(i: Int): Int = i / 2
fun left(i: Int): Int = 2 * i
fun right(i: Int): Int = (2 * i) + 1

