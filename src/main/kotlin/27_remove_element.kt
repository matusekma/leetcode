fun removeElement(nums: IntArray, element: Int): Int {
    var firstIndex = 0
    var secondIndex = 0
    var k = 0
    while (secondIndex < nums.size) {
        if (nums[secondIndex] == element) {
            secondIndex++
        } else {
            nums[firstIndex] = nums[secondIndex]
            firstIndex++
            secondIndex++
            k++
        }
    }
    return k
}

fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val element = 3
    val result = removeElement(nums, element)
    println(result)
    println(nums.joinToString())
}