package utils

import (
	"bytes"
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// For printing list
func (head *ListNode) String() string {
	buf := new(bytes.Buffer)
	p := head
	for p != nil {
		buf.WriteString(fmt.Sprintf("%d -> ", p.Val))
		p = p.Next
	}
	buf.WriteString("nil")
	return buf.String()
}
