package problem55

import "testing"

func testCase(t *testing.T, solution Solution, nums []int) {
	ans := solution.CanJump(nums)
	t.Log(ans)
}

type Case struct {
	solution Solution
	nums     []int
}

var cases []Case = []Case{
	{&Solution0{}, []int{2, 3, 1, 1, 4}},
	{&Solution0{}, []int{3, 2, 1, 0, 4}},
}

func TestCanJump(t *testing.T) {
	for _, row := range cases {
		testCase(t, row.solution, row.nums)
	}
}
