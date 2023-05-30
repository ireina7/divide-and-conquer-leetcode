package problem173

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type BSTIterator struct {
	ch  chan int
	buf []int
}

func Constructor(root *TreeNode) BSTIterator {
	iter := BSTIterator{
		ch:  make(chan int),
		buf: []int{},
	}
	iter.Run(root)
	return iter
}

func (this *BSTIterator) dfs(tree *TreeNode) {
	if tree == nil {
		return
	}
	this.dfs(tree.Left)
	this.ch <- tree.Val
	this.dfs(tree.Right)
}

func (this *BSTIterator) Run(tree *TreeNode) {
	go func() {
		this.dfs(tree)
		close(this.ch)
	}()
}

func (this *BSTIterator) Next() int {
	var x int
	if len(this.buf) > 0 {
		x = this.buf[0]
		this.buf = this.buf[1:]
	} else {
		x = <-this.ch
	}
	return x
}

func (this *BSTIterator) HasNext() bool {
	if len(this.buf) > 0 {
		return true
	}
	x, open := <-this.ch
	if !open {
		return false
	}
	this.buf = append(this.buf, x)
	return true
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
