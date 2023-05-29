package utils

import "fmt"

type Ordered[T comparable] interface {
	comparable
	Less(b T) bool
}

type Index = int

func BinarySearch[T Ordered[T]](xs []T, target T) (Index, error) {
	// pre-condition: `xs` is sorted
	if len(xs) == 0 {
		return -1, fmt.Errorf("%#v Not found", target)
	}
	i := 0
	j := len(xs) - 1
	k := i + ((j - i) >> 1)
	if xs[k] == target {
		return k, nil
	} else if xs[k].Less(target) {
		return BinarySearch(xs[k+1:], target)
	} else {
		return BinarySearch(xs[:k], target)
	}
}
