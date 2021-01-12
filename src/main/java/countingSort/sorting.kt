package countingSort


fun main() {
    val xs = mutableListOf(2, 5, 3, 0, 2, 3, 0, 3)
    val ys = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
    val countingSort = countingSort(xs, ys, 6)
    print(countingSort)
}

fun countingSort(xs: MutableList<Int>, output: MutableList<Int>, k: Int): MutableList<Int> {
    val count = IntArray(k)
    for (i in 0 until k) {
        count[i] = 0
    }

    for (j in 0 until xs.size) {
        count[xs[j]] = count[xs[j]] + 1
    }

    for (i in 1 until k) {
        count[i] = count[i] + count[i-1]
    }

    for (j in (xs.size - 1) downTo 0 ) {
        output[count[xs[j]] - 1] = xs[j]
        count[xs[j]] = count[xs[j]] -1
    }
    return output
}
