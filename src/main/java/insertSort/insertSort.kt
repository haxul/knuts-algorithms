fun main() {
    val initList = mutableListOf(10, 5, 9, 6, 7, 8)
    val sortedList = insertSort(initList)
    print(sortedList)
}

fun insertSort(list: MutableList<Int>): List<Int> {
    for ((inx, _) in list.withIndex()) {
        val key = list[inx]
        var prevInx = inx - 1
        while (prevInx >= 0 && list[prevInx] > key) {
            list[prevInx + 1] = list[prevInx]
            prevInx--
        }
        list[prevInx + 1] = key
    }
    return list
}