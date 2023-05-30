package problem100

type Solution0 struct{}

func (self *Solution0) IsSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}
	if p == nil || q == nil {
		return false
	}
	if p.Val == q.Val {
		return self.IsSameTree(p.Left, q.Left) && self.IsSameTree(p.Right, q.Right)
	}
	return false
}
