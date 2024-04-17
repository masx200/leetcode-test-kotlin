package com.github.masx200.leetcode_test_kotlin.split_strings_by_separator

class Solution {
    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {

        return words.flatMap { it.split(separator).filter { it.isNotEmpty() } }
    }
}