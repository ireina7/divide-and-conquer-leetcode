package problem151

type Solution0 struct{}

func (self *Solution0) ReverseWords(s string) string {
	i := 0
	for i < len(s) && s[i] == ' ' {
		i += 1
	}
	s = s[i:]
	if len(s) == 0 {
		return ""
	}
	j := 0
	for j < len(s) && s[j] != ' ' {
		j += 1
	}
	word := s[:j]
	rest := self.ReverseWords(s[j:])
	if rest == "" {
		return word
	}
	return rest + " " + word
}
