package com.github.masx200.leetcode_test_kotlin.find_closest_number_to_zero

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun findClosestNumber(nums: IntArray): Int {
        return nums.reduce { a, b ->
            if (abs(a) < abs(b)) a else if (abs(a) == abs(b))
                max(a, b)
            else b
        }
    }
}