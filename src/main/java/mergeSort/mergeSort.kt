package mergeSort

fun main() {
    val bx = listOf(2, 8, 11, 12, 3, 1 ,15, 24,40, 0)
    val mergeSort = mergeSort(bx)
    println(mergeSort);
}


fun mergeSort(xs: List<Int>): List<Int> {
    if (xs.size == 1) return xs
    val ax = mergeSort(xs.subList(0, xs.size / 2))
    val bx = mergeSort(xs.subList(xs.size/2, xs.size))
    return merge(ax, bx)
}

fun merge(ax: List<Int>, bx: List<Int>): List<Int> {
    val maxLen = ax.size + bx.size
    val sortList = mutableListOf<Int>()
    var (i, j) = Pair(0,0)

    for (inx in 0 until maxLen) {
        if (i >= ax.size) {
            sortList.add(bx[j++])
            continue
        }
        if (j >= bx.size) {
            sortList.add(ax[i++])
            continue
        }

        val r = if (ax[i] < bx[j]) ax[i++] else bx[j++]
        sortList.add(r)
    }

    return sortList
}
