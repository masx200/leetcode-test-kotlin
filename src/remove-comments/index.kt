package com.github.masx200.leetcode_test_kotlin.remove_comments

import java.util.regex.Pattern

class Solution {
    fun removeComments(source: Array<String>): List<String> {
        val str = source.joinToString(separator = "\n")

        return Pattern.compile("//.*|/\\*(.|\\n)*?\\*/").matcher(str).replaceAll("").split("\n")


            .filter {
                it.isNotEmpty()
            }
    }
}
