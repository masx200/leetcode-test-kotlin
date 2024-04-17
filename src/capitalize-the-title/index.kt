package com.github.masx200.leetcode_test_kotlin.capitalize_the_title

import java.util.Locale

class Solution {
    fun capitalizeTitle(title: String): String {
        return title.split(" ").map { it.lowercase() }.joinToString(" ") {
            if (it.length < 3) it else it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    }
}