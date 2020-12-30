package heapSort
// O(n lg n)
fun main() {
    val list = mutableListOf(200, 2, 12, 23, 4, 10, 2, 100, 101, 102)
    heapSort(list)
    print(list)
}

/** heap methods */

fun parent(i: Int): Int = i / 2
fun left(i: Int): Int = 2 * i
fun right(i: Int): Int = (2 * i) + 1

fun heapSort(A: MutableList<Int>) {
    var heapSize = A.size
    buildMaxHeap(A)
    for (i in (A.size - 1) downTo 1) {
        A[0] = A[i].also { A[i] = A[0] }
        heapSize--
        maxHeapify(A, 0, heapSize)
    }
}

fun buildMaxHeap(A: MutableList<Int>) {
    val heapSize = A.size
    val mid = A.size / 2
    for (i in mid downTo 0) {
        maxHeapify(A, i, heapSize)
    }
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
