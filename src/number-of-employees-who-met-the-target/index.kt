package com.github.masx200.leetcode_test_kotlin.number_of_employees_who_met_the_target

class Solution {
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        return hours.count { it >= target }
    }
}