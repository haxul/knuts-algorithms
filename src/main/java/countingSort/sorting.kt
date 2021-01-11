package countingSort


fun main() {
    val xs = mutableListOf(2, 5, 3, 0, 2, 3, 0, 3)
    val ys = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0)
    val countingSort = countingSort(xs, ys, 8)
    print(countingSort)
}

fun countingSort(xs: MutableList<Int>, ys: MutableList<Int>, k: Int): MutableList<Int> {
    val tmpList = ArrayList<Int>()
    for (i in 0 until k) {
        tmpList.add(0)
    }

    for (j in 0 until xs.size) {
        tmpList[xs[j]] = tmpList[xs[j]] + 1
    }

    for (i in 1 until k) {
        tmpList[i] = tmpList[i] + tmpList[i-1]
    }

    for (j in (xs.size - 1) downTo 0 ) {
        ys[tmpList[xs[j]]] = xs[j]
        tmpList[xs[j]] = tmpList[xs[j]] -1
    }
    return ys
}