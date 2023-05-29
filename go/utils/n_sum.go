package utils

import "sort"

func NSum(xs []int, target int, n int) [][]int {
	if len(xs) < n {
		return [][]int{}
	}
	sort.Ints(xs)
	if n == 1 {
		i := sort.SearchInts(xs, target)
		if i == len(xs) {
			return [][]int{}
		}
		return [][]int{{target}}
	}
	if n == 2 {
		return twoSum(xs, target)
	}
	ans := [][]int{}
	for k := 0; k < len(xs)-n+1; {
		num := xs[k]
		rest := NSum(xs[k+1:], target-num, n-1)
		for i := 0; i < len(rest); i++ {
			rest[i] = append(rest[i], num)
			ans = append(ans, rest[i])
		}
		for k < len(xs)-n+1 && xs[k] == num {
			k += 1
		}
	}
	return ans
}

func twoSum(nums []int, target int) [][]int {
	if !sort.IntsAreSorted(nums) {
		sort.Ints(nums)
	}
	ans := [][]int{}
	i, j := 0, len(nums)-1
	for i < j {
		a, b := nums[i], nums[j]
		sum := a + b
		if sum == target {
			ans = append(ans, []int{nums[i], nums[j]})
			for i < j && nums[i] == a {
				i += 1
			}
			for i < j && nums[j] == b {
				j -= 1
			}
		} else if sum < target {
			for i < j && nums[i] == a {
				i += 1
			}
		} else {
			for i < j && nums[j] == b {
				j -= 1
			}
		}
	}
	return ans
}
