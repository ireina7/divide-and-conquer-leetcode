package problem94

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Solution interface {
	InorderTraversal(root *TreeNode) []int
}
