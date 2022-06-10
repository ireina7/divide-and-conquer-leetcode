package leetcode.problem22;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 * */
public class Solution0 {
    /**
     * Depth first searching
     * @param n the number of pairs.
     * @return combinations.
     * */
    Stream<String>
    dfs(int n) {
        if(n == 0) return Stream.of("");
        return IntStream
            .range(0, n)
            .boxed()
            .flatMap(
                i -> dfs(i).flatMap(
                    l -> dfs(n - i - 1).map(
                        r -> String.format("(%s)%s", l, r)
                    )
                )
            );
    }
    /**
     * The entry
     * */
    public List<String>
    generateParenthesis(int n) {
        return dfs(n).collect(Collectors.toList());
    }
}




