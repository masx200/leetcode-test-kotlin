package com.github.masx200.leetcode_test_kotlin.day_of_the_week

import java.time.LocalDate

class Solution {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val week = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

        val date = LocalDate.of(year, month, day)
        return week[date.getDayOfWeek().value % 7]
    }
}
