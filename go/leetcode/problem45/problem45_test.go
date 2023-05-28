package problem45

import "testing"

func TestSolution(t *testing.T) {
	solution := Solution0{}
	nums := []int{2, 3, 0, 1, 4}
	ans := solution.Jump(nums)
	t.Log("ans", ans)
}
