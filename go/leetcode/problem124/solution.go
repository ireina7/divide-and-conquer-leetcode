package problem124

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Solution interface {
	MaxPathSum(root *TreeNode) int
}
