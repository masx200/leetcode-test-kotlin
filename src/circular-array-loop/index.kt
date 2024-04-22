package com.github.masx200.leetcode_test_kotlin.circular_array_loop

class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {


        val len = nums.size


        for (i in 0 until len) {
            val visited = mutableSetOf<Int>()
            var symbol: Int? = null
            var cur: Int = i
            while (true) {
                if (symbol != null && nums[cur % len] * symbol <= 0) break
                if (symbol == null) symbol = nums[cur % len]
                if (visited.contains(cur % len)) {
                    val next = if (nums[cur % len] >= 0) cur + nums[cur % len] else cur + len + nums[cur % len]
                    if (next % len == cur % len) break
                    if (visited.size == 1) break
                    return true
                }
                visited.add(cur % len)
                cur += if (nums[cur % len] >= 0) {
                    nums[cur % len] % len
                } else {
                    len + nums[cur % len] % len
                }
            }

        }
        return false

    }
}