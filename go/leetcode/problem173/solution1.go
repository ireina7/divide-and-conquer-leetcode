package problem173

type BSTIterator1 struct {
	stack []*TreeNode
	p     *TreeNode
}

func Constructor1(root *TreeNode) BSTIterator1 {
	iter := BSTIterator1{
		stack: []*TreeNode{},
		p:     root,
	}
	for root != nil {
		iter.stack = append(iter.stack, root)
		root = root.Left
	}
	return iter
}

func (this *BSTIterator1) Next() int {
	n := len(this.stack)
	node := this.stack[n-1]
	this.stack = this.stack[:n-1]

	r := node.Right
	for r != nil {
		this.stack = append(this.stack, r)
		r = r.Left
	}
	return node.Val
}

func (this *BSTIterator1) HasNext() bool {
	return len(this.stack) > 0
}
