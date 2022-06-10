package leetcode.problem38;
import java.util.*;
import java.util.stream.IntStream;

public class Solution0 {
    public String countAndSay(int n) {
        return IntStream.range(0, n - 1)
            .boxed()
            .map(i -> String.format("%d", i))
            .reduce("1", (a, x) -> say(a));
    }
    String say(String s) {
        if(s.length() == 0) {
            return "";
        }
        if(s.length() == 1) {
            return "1" + s;
        }
        List<int[]> set = new ArrayList<>();
        set.add(new int[]{Character.digit(s.charAt(0), 10), 1});
        for(int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                int[] tuple = set.get(set.size() - 1);
                tuple[1] += 1;
            } else {
                set.add(new int[]{Character.digit(s.charAt(i), 10), 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < set.size(); ++i) {
            String ss = String.format("%d%d", set.get(i)[1], set.get(i)[0]);
            sb.append(ss);
        }
        return sb.toString();
    }
}
