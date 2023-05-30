package problem124

type Solution0 struct{}

func (self *Solution0) MaxPathSum(root *TreeNode) int {
	ans, _ := self.dfs(root)
	return ans
}

func (self *Solution0) dfs(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}
	if root.Left == nil && root.Right == nil {
		return root.Val, root.Val
	}
	if root.Left == nil {
		rs, rp := self.dfs(root.Right)
		pp := max(root.Val, root.Val+rp)
		ans := max(rs, pp)
		return ans, pp
	}
	if root.Right == nil {
		ls, lp := self.dfs(root.Left)
		pp := max(root.Val, lp+root.Val)
		ans := max(ls, pp)
		return ans, pp
	}
	ls, lp := self.dfs(root.Left)
	rs, rp := self.dfs(root.Right)
	pp := max(lp+root.Val, rp+root.Val)
	pp = max(pp, root.Val)
	ans := max(ls, rs)
	ans = max(ans, pp)
	ans = max(ans, lp+root.Val+rp)
	return ans, pp
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
