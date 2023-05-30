package problem100

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Solution interface {
	IsSameTree(p *TreeNode, q *TreeNode) bool
}
