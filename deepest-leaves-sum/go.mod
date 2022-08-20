module github.com/masx200/leetcode-test/deepest-leaves-sum

go 1.19

require github.com/masx200/leetcode-test/serialize-and-deserialize-binary-tree v0.0.0

replace github.com/masx200/leetcode-test/serialize-and-deserialize-binary-tree v0.0.0 => ../serialize-and-deserialize-binary-tree

require (
	github.com/masx200/leetcode-test/utils v0.0.0
	gotest.tools/v3 v3.3.0
)

require (
	github.com/egregors/TreeNode v1.0.3 // indirect
	github.com/google/go-cmp v0.5.8 // indirect
)

replace github.com/masx200/leetcode-test/utils v0.0.0 => ../utils