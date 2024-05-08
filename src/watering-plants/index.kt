package com.github.masx200.leetcode_test_kotlin.watering_plants

class Solution {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        val n = plants.size
        var ans = 0
        var rest = capacity
        for (i in 0 until n) {
            if (rest >= plants[i]) {
                ans++
                rest -= plants[i]
            } else {
                ans += i * 2 + 1
                rest = capacity - plants[i]
            }
        }
        return ans
    }
}