package leetcode.problem43;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.cn/problems/multiply-strings/
 * */
public class Solution0 {
    List<Integer> num1;
    List<Integer> num2;
    public String multiply(String num1, String num2) {
        this.num1 = num1.chars().boxed().map(c -> c - '0').collect(Collectors.toList());
        this.num2 = num2.chars().boxed().map(c -> c - '0').collect(Collectors.toList());
        List<Integer> ds = handle(num1.length() - 1, num2.length() - 1, 0);
        return ds.stream().map(i -> i.toString()).collect(Collectors.joining());
    }
    List<Integer> handle(int i, int j, int c) {
        List<Integer> ans = new ArrayList<>();
        int sum = num1.get(i) * num2.get(j) + c;
        ans.add(0, sum % 10);
        return ans;
    }
}
