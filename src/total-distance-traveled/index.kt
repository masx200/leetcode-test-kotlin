package com.github.masx200.leetcode_test_kotlin.total_distance_traveled

import kotlin.math.min

class Solution {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        return 10 * (mainTank + min((mainTank - 1) / 4, additionalTank))
    }
}