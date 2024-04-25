package com.github.masx200.leetcode_test_kotlin.total_distance_traveled

class Solution {
    fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {
        return 10 * (mainTank + min((mainTank - 1) / 4, additionalTank));
    }
}