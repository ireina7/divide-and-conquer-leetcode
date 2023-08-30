package problem56

import "testing"

type Intervals [][]int

var cases = []Intervals{
	{{5, 2}, {1, 2}, {2, 3}},
}

func TestSolution(t *testing.T) {
	solution := &Solution0{}
	ans := solution.Merge(cases[0])
	t.Logf("%#+v", ans)
}
