package leetcode.problem60;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
/**
 * https://leetcode.cn/problems/permutation-sequence/
 * */
public class Solution0 {
    int n;
    int[] nums;
    public String getPermutation(int n, int k) {
        this.n = n;
        this.nums = new int[n];
        return dfs(k);
    }
    String dfs(int k) {
        if(k == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < nums.length; ++i) {
                if(nums[i] == 0) {
                    sb.append(String.format("%s", i + 1));
                }
            }
            return sb.toString();
        }
        int cnt = (int)Arrays.stream(nums).filter(n -> n == 0).count();
        int fact = IntStream.range(1, cnt).reduce(1, (a, b) -> a * b);
        int groupId = k / fact;
        int headIdx = 0;
        while(nums[headIdx] != 0) ++headIdx;
        cnt = 0;
        for(; headIdx < nums.length && cnt <= groupId; ++headIdx) {
            if(nums[headIdx] == 0) cnt += 1;
        }
        headIdx -= 1;
        if(cnt < groupId) return "";
        nums[headIdx] = 1;
        String ss = dfs(k % fact);
        return String.format("%s%s", headIdx + 1, ss);
    }
    
    public static void main(String[] args) {
        int n = 20;
        int k = 5;
        System.out.printf("Test getPermutation(%d, %d)\n", n, k);
        Solution0 solution = new Solution0();
        String s = solution.getPermutation(n, k);
        System.out.printf("Got %s\n", s);
    }
}
