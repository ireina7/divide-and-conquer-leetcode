package leetcode.problem151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution0 {
    public String reverseWords(String s) {
        List<String> cs =
            Arrays.stream(s.trim().split(" +"))
                .collect(Collectors.toList());
        Collections.reverse(cs);
        return cs.stream().collect(Collectors.joining(" "));
    }
}
