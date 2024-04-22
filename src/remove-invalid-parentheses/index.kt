package  com.github.masx200.leetcode_test_kotlin.remove_invalid_parentheses

class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
        val ans = mutableListOf<String>()
        val currSet = mutableSetOf<String>()

        currSet.add(s)
        while (true) {
            for (str in currSet) {
                if (isValid(str)) {
                    ans.add(str)
                }
            }
            if (ans.isNotEmpty()) {
                return ans
            }
            val nextSet = mutableSetOf<String>()
            for (str in currSet) {
                for (i in str.indices) {
                    if (i > 0 && str[i] == str[i - 1]) {
                        continue
                    }
                    if (str[i] == '(' || str[i] == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1))
                    }
                }
            }
            currSet.clear()
            currSet.addAll(nextSet)
        }
    }

    fun isValid(str: String): Boolean {
        val ss = str.toCharArray()
        var count = 0

        for (c in ss) {
            if (c == '(') {
                count++
            } else if (c == ')') {
                count--
                if (count < 0) {
                    return false
                }
            }
        }

        return count == 0
    }
}