package problem56

import "sort"

// Better solution!
type Solution1 struct{}

func (self *Solution1) Merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][1] == intervals[j][1] {
			return intervals[i][0] < intervals[j][0]
		}
		return intervals[i][1] < intervals[j][1]
	})
	return self.dfs(intervals)
}

func (self *Solution1) dfs(xs [][]int) [][]int {
	if len(xs) <= 1 {
		return xs
	}
	x := xs[0]
	rest := self.dfs(xs[1:])
	n := len(rest)
	y := rest[n-1]
	if x[1] < y[0] {
		rest = append(rest, x)
		return rest
	}
	if x[0] >= y[0] {
		return rest
	}
	rest = rest[:n-1]
	rest = append(rest, []int{x[0], y[1]})
	return rest
}
