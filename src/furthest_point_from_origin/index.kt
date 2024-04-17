package com.github.masx200.leetcode_test_kotlin.furthest_point_from_origin

class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        return Math.abs(moves.count { 'R' == it } - moves.count { 'L' == it }) + moves.count { '_' == it }
    }
}