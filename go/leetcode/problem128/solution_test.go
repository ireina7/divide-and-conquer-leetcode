package problem128

import "testing"

var (
	cases = [][]int{
		{0, 0, 1, -1},
	}
)

func testSolution(t *testing.T, solution Solution) error {
	nums := cases[0]
	ans := solution.LongestConsecutive(nums)
	t.Logf("ans: %+v\n", ans)
	t.Logf("map: %+v\n", solution)
	return nil
}

func TestMe(t *testing.T) {
	solution := NewSolution0()
	err := testSolution(t, solution)
	if err != nil {
		t.Error(err)
	}
}
