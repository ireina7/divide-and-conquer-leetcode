package utils

import (
	"fmt"

	"golang.org/x/exp/constraints"
)

func nextPermutation[A constraints.Ordered](nums []A) {
	n := len(nums)
	i := n - 1
	for i > 0 && nums[i-1] >= nums[i] {
		i -= 1
	}
	if i == 0 {
		ReverseSlice[A](nums).Reverse()
		return
	}
	i -= 1
	j := n - 1
	for j >= i && nums[j] <= nums[i] {
		j -= 1
	}
	fmt.Println(i, j)
	SwapSlice[A](nums).Swap(i, j)
	ReverseSlice[A](nums[i+1:]).Reverse()
}

type SwapSlice[A any] []A

func (xs SwapSlice[A]) Swap(i, j int) {
	temp := xs[i]
	xs[i] = xs[j]
	xs[j] = temp
}

type ReverseSlice[A any] []A

func (xs ReverseSlice[A]) Reverse() {
	i := 0
	j := len(xs) - 1
	for i < j {
		SwapSlice[A](xs).Swap(i, j)
		i += 1
		j -= 1
	}
}

type NextPermutation[A constraints.Ordered] []A

func (self NextPermutation[A]) NextPermutation() {
	nextPermutation(self)
}
