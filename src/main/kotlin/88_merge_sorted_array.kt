import kotlin.system.measureTimeMillis

fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (n == 0) return
    val num1sStore = mutableListOf<Int>()
    var currentIndexNum2 = 0
    (0..(m + n - 1)).forEach { index ->
        if (index < m && currentIndexNum2 < n) {
            val currentNum1 = nums1[index]
            val currentNum2 = nums2[currentIndexNum2]
            if (num1sStore.isNotEmpty() && num1sStore[0] <= currentNum2) {
                nums1[index] = num1sStore.removeAt(0)
                num1sStore.add(currentNum1)
            } else if (currentNum1 > currentNum2) {
                num1sStore.add(currentNum1)
                nums1[index] = currentNum2
                currentIndexNum2++
            }
        } else if (currentIndexNum2 < n) {
            val currentNum2 = nums2[currentIndexNum2]
            if (num1sStore.isNotEmpty() && num1sStore[0] <= currentNum2) {
                nums1[index] = num1sStore.removeAt(0)
            } else {
                nums1[index] = nums2[currentIndexNum2++]
            }
        } else if (index < m) {
            val currentNum1 = nums1[index]
            if (num1sStore.isNotEmpty()) {
                nums1[index] = num1sStore.removeAt(0)
                num1sStore.add(currentNum1)
            }
        } else {
            if (num1sStore.isNotEmpty()) {
                nums1[index] = num1sStore.removeAt(0)
            }
        }
    }
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var num1Index = m - 1
    var num2Index = n - 1
    var currentIndex = m + n - 1
    while (num2Index >= 0) {
        if (num1Index >= 0 && nums1[num1Index] > nums2[num2Index]) {
            nums1[currentIndex--] = nums1[num1Index--]
        } else {
            nums1[currentIndex--] = nums2[num2Index--]
        }
    }
}

fun main() {
    val nums1 = intArrayOf(2, 0)
    val m = 1
    val nums2 = intArrayOf(1)
    val n = 1
    measureTimeMillis {
        merge(nums1, m, nums2, n)
    }.also { println("Time: $it ms") }

    println(nums1.joinToString())
}