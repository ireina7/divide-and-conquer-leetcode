package problem45

import (
	"fmt"
)

type Solution0 struct{}

func (self *Solution0) Jump(nums []int) int {
	n, err := self.dfs(nums)
	if err != nil {
		return -1
	}
	return n
}

func (self *Solution0) dfs(nums []int) (int, error) {
	if len(nums) == 0 {
		return 0, fmt.Errorf("Empty slice")
	}
	if len(nums) == 1 {
		return 0, nil
	}
	// Greedy choice
	if nums[0] == 0 {
		return 0, fmt.Errorf("Cannot reach end")
	}
	next := 1
	end := 0
	for i := 1; i <= nums[0]; i++ {
		if i == len(nums) {
			return 1, nil
		}
		if i+nums[i] > end {
			next = i
			end = i + nums[i]
		}
	}
	n, err := self.dfs(nums[next:])
	if err != nil {
		return 0, err
	}
	return 1 + n, nil
}
