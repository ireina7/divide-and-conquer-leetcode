package utils

import "fmt"

func StrStr(s string, p string) int {
	kmp := Kmp[byte]{}
	i, err := kmp.Match([]byte(s), []byte(p))
	if err != nil {
		return -1
	}
	return i
}

type MatchSlice[A comparable] interface {
	Match(s, p []A) (int, error)
}

type Kmp[A comparable] struct {
	next []int
}

func (kmp *Kmp[A]) Match(s, p []A) (int, error) {
	kmp.next = getNext(p)
	return kmp.dfs(s, p, 0, 0)
}

func (kmp *Kmp[A]) dfs(s, p []A, i, j int) (int, error) {
	if len(p[j:]) > len(s[i:]) {
		return 0, fmt.Errorf("No match")
	}
	d := match(s[i:], p[j:])
	if d == len(p[j:]) { // Found match
		return i - j, nil
	}
	if d == 0 && j == 0 { // matched nothing
		return kmp.dfs(s, p, i+1, 0)
	}
	k := kmp.next[j+d-1]
	return kmp.dfs(s, p, i+d, k)
}

func getNext[A comparable](p []A) []int {
	next := make([]int, len(p))
	next[0] = 0
	for i := 1; i < len(p); i++ {
		for j := i; j > 0; {
			if p[i] == p[next[j-1]] {
				next[i] = next[j-1] + 1
				break
			} else {
				j = next[j-1]
			}
		}
	}
	return next
}

func match[A comparable](s, p []A) int {
	i := 0
	for i < len(p) {
		if s[i] != p[i] {
			return i
		}
		i += 1
	}
	return i
}
