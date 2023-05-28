package problem274

import "sort"

type Solution0 struct{}

func (self *Solution0) HIndex(cs []int) int {
	sort.Ints(cs)
	n := len(cs)
	for i, x := range cs {
		if x >= n-i {
			return n - i
		}
	}
	return 0
}
