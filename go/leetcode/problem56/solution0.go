package problem56

import (
	"sort"
)

// HACK Naive, very naive...
type Solution0 struct{}

func (self *Solution0) Merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	return self.dfs(intervals)
}

func (self *Solution0) dfs(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}
	x := intervals[0]
	xs := intervals[1:]
	rest := self.dfs(xs)
	ans := make([][]int, 0)
	for i := range rest {
		y := rest[i]
		if x[1] < y[0] {
			ans = append(ans, x)
			ans = append(ans, rest[i:]...)
			return ans
		}
		if x[1] <= y[1] {
			ans = append(ans, []int{x[0], y[1]})
			ans = append(ans, rest[i+1:]...)
			return ans
		}
	}
	ans = append(ans, x)
	return ans
}
