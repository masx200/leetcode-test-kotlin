package com.github.masx200.leetcode_test_kotlin.kth_ancestor_of_a_tree_node

class TreeAncestor(val n: Int, private val parent: IntArray) {
    private val cache = hashMapOf<Int, MutableMap<Int, Int>>()

    fun getKthAncestor(node: Int, k: Int): Int {
        if (!cache.containsKey(node)) cache[node] = hashMapOf()
        val map = cache[node]
        if (map?.containsKey(k) == true) return map[k]!!

        return when {
            node == 0 -> -1
            node == -1 -> -1
            k == 0 -> node
            k == 1 -> parent[node]
            else -> {
                val even = 1.shl((k - 1).countOneBits())
                val half = if (even == k) k / 2 else even

                val res = getKthAncestor(getKthAncestor(node, half), k - half)
                map!![k] = res
                res
            }
        }
    }
}
