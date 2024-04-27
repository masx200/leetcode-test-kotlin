package com.github.masx200.leetcode_test_kotlin.the_masseuse_lcci

class Solution {
    fun massage(nums: IntArray): Int {
        return when {
            nums.size == 1 -> nums[0]
            nums.isEmpty() -> 0
            else -> {
                val dp = mutableListOf(0, 0)

                for (num in nums) {
                    dp.add(maxOf(num + dp[0], dp[1]))
                    dp.removeAt(0)
                }
                dp[1]
            }


        }
    }
}