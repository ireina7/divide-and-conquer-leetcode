package problem173

import (
	"testing"
)

func TestSolution(t *testing.T) {
	tree := new(TreeNode)
	tree.Val = 1
	tree.Left = nil
	tree.Right = new(TreeNode)
	tree.Right.Val = 2

	iter := Constructor(tree)
	t.Log(iter.HasNext())
	t.Log(iter.Next())
	t.Log(iter.HasNext())
	t.Log(iter.Next())
	t.Log(iter.HasNext())
}
