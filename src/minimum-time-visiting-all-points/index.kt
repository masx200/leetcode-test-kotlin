package com.github.masx200.leetcode_test_kotlin.`minimum_time_visiting_all_points`

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {

        var x0 = points[0][0]
        var y0 = points[0][1]
        var ans = 0
        for (i in 1 until points.size) {
            val x1 = points[i][0]
            val y1 = points[i][1]
            ans += Math.max(Math.abs(x0 - x1), Math.abs(y0 - y1))
            x0 = x1
            y0 = y1
        }
        return ans
    }
}