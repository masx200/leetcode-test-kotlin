package com.github.masx200.leetcode_test_kotlin.insert_into_a_binary_search_tree

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode {
        if (root == null) return TreeNode(`val`)
        if (root.`val` > `val`) root.left = insertIntoBST(root.left, `val`)
        if (root.`val` < `val`) root.right = insertIntoBST(root.right, `val`)
        return root
    }
}
