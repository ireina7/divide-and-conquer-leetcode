package problem94

type Solution0 struct {
}

func (self *Solution0) InorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	v := root.Val
	ls := self.InorderTraversal(root.Left)
	rs := self.InorderTraversal(root.Right)
	ls = append(ls, v)
	ls = append(ls, rs...)
	return ls
}
