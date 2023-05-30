package problem1110

type Solution0 struct {
	dict map[int]bool
}

func (self *Solution0) DelNodes(root *TreeNode, to_delete []int) []*TreeNode {
	for _, x := range to_delete {
		self.dict[x] = true
	}
	ans, node := self.dfs(root)
	if node != nil {
		ans = append(ans, node)
	}
	return ans
}

func (self *Solution0) dfs(root *TreeNode) ([]*TreeNode, *TreeNode) {
	ans := []*TreeNode{}
	if root == nil {
		return ans, nil
	}
	ls, ln := self.dfs(root.Left)
	rs, rn := self.dfs(root.Right)
	ans = append(ans, ls...)
	ans = append(ans, rs...)
	_, found := self.dict[root.Val]
	if found {
		if ln != nil {
			ans = append(ans, ln)
		}
		if rn != nil {
			ans = append(ans, rn)
		}
		return ans, nil
	}
	root.Left = ln
	root.Right = rn
	return ans, root
}
