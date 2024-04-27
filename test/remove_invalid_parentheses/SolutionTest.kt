package com.github.masx200.leetcode_test_kotlin.remove_invalid_parentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolutionTest {
    @Test
    fun removeInvalidParentheses1() {
        val solution = Solution()

        val testCases = listOf(
            Pair(")(", listOf("")),

            )

        for ((s, expected) in testCases) {
            assertEquals(expected.toSet(), solution.removeInvalidParentheses(s).toSet())
        }
    }

    @Test
    fun removeInvalidParentheses() {
        val solution = Solution()

        val testCases = listOf(
            Pair("()())()", listOf("()()()", "(())()")),
            Pair("(a)())()", listOf("(a)()()", "(a())()")),

            )

        for ((s, expected) in testCases) {
            assertEquals(expected.toSet(), solution.removeInvalidParentheses(s).toSet())
        }
    }

    @Test
    fun removeInvalidParentheses2() {
        val solution = Solution()

        val testCases = listOf(

            Pair("())", listOf("()")),
            Pair("(())(()", listOf("(())()")),
            Pair("", listOf(""))
        )

        for ((s, expected) in testCases) {
            assertEquals(expected.toSet(), solution.removeInvalidParentheses(s).toSet())
        }
    }
}