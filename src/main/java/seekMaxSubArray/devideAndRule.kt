package seekMaxSubArray

fun main() {
    val users = listOf(User("serg", 10, listOf("php", "js")), User("august", 21, listOf("java", "c#")))
    /* O(n^2)
    for (user in users) {
        for (skill in user.skills) {
            println(skill.toUpperCase())
        }
    }
     */
    // O (n * lg n)
    val mapSkill = mapSkill(users)
    print(mapSkill)
}


fun mapSkill(users: List<User>): List<String> {
    if (users.size == 1) return users[0].skills // get what we need to process
    // dividing
    val mid = users.size / 2
    val lUsers = users.subList(0, mid)
    val rUsers = users.subList(mid, users.size)
    val skillsLeft = mapSkill(lUsers)
    val skillsRight = mapSkill(rUsers)
    // progressing
    return skillsLeft.map { it.toUpperCase() } + skillsRight.map { it.toUpperCase() }
}

class User(private val name: String, private val age: Int, val skills: List<String>) {
    fun greet() {
        println("name is $name, age is $age")
    }
}



fun sumIfMore50(list: List<Int>): Int {
    if (list.size == 1) return if (list[0] < 10) list[0] else 0
    val mid = list.size / 2
    val leftSum = sumIfMore50(list.subList(0, mid))
    val rightSum = sumIfMore50(list.subList(mid, list.size))
    return leftSum + rightSum
}

fun findMinValue(list: List<Int>): Int {
    if (list.size == 1) return list[0]
    val mid = list.size / 2
    val minLeft = findMinValue(list.subList(0, mid))
    val minRight = findMinValue(list.subList(mid, list.size))
    return if (minLeft < minRight) minLeft else minRight
}

fun sumArray(nums: List<Int>): Int {
    if (nums.size == 1) return nums[0]
    val mid = nums.size / 2
    val sumLeft = sumArray(nums.subList(0, mid))
    val sumRight = sumArray(nums.subList(mid, nums.size))
    return sumLeft + sumRight
}

