package problem11

import (
	"fmt"
	"testing"
)

type TestCase []int

var cases = []TestCase{
	{1, 8, 6, 2, 5, 4, 8, 3, 7},
}

func TestMe(t *testing.T) {
	solution := &Solution0{}
	ans := solution.MaxArea(cases[0])
	fmt.Println(ans)
}
