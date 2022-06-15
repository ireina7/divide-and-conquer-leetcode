package leetcode.problem349;
import java.util.*;
import java.util.stream.Collectors;

public class Solution0 {
    int[] nums1;
    int[] nums2;
    Set<Integer> memo;
    public int[] intersection(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo = new HashSet<>();
        for(int x : nums1) memo.add(x);
        return dfs(0).stream().mapToInt(x -> x).toArray();
    }
    List<Integer> dfs(int i) {
        if(i == nums2.length) {
            return new ArrayList<>();
        }
        if(memo.contains(nums2[i])) {
            memo.remove(nums2[i]);
            List<Integer> xs = dfs(i + 1);
            xs.add(0, nums2[i]);
            return xs;
        }
        return dfs(i + 1);
    }
}
