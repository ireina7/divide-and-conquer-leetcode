package leetcode.problem18;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Let's try to build an algorithm to solve all n-sum problems.
 * Using divide-and-conquer.
 * */
public class Solution0 {
  List<Integer> nums;
  /**
   * So let's first build 2-sum.
   * */
  List<List<Integer>> twoSum(int i, int j, int target) {
    if(nums.size() < 2) {
      return List.of();
    }
    if(nums.size() == 2) {
      int sum = nums.stream().limit(2).reduce(0, (a, b) -> a + b);
      return sum == target ? List.of(nums) : List.of();
    }
    List<List<Integer>> ans = new ArrayList<>();
    while(i < j) {
      int sum = nums.get(i) + nums.get(j);
      if(sum == target) {
        ans.add(List.of(nums.get(i), nums.get(j)));
        i += 1;
        j -= 1;
      } else if(sum < target) {
        i += 1;
      } else {
        j -= 1;
      }
    }
    return ans;
  }
  /**
   * Let's do the job.
   * */
  List<List<Integer>> dfs(int i, int j, int target, int n) {
    if(j - i + 1 < n) return List.of();
    if(n <= 0) return List.of();
    if(n == 1) {
      return nums.contains(target)
          ? List.of(List.of(target)) : List.of();
    }
    if(n == 2) {
      return twoSum(i, j, target);
    }
    Set<List<Integer>> ans = new HashSet<>();
    for(int k = i; k <= j - n + 1; ++k) {
      List<List<Integer>> rest =
          dfs(k + 1, j, target - nums.get(k), n - 1);
      for(var xs : rest) {
        List<Integer> ys = new ArrayList<>(xs);
        ys.add(0, nums.get(k));
        ans.add(ys);
      }
    }
    return ans.stream().collect(Collectors.toList());
  }

  public List<List<Integer>> nSum(List<Integer> nums, int target, int n) {
    this.nums = nums.stream()
        .sorted()
        .collect(Collectors.toList());
    return dfs(0, nums.size() - 1, target, n);
  }

  public List<List<Integer>> fourSum(int[] nums, int target) {
    return nSum(
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList()),
        target,
        4
    );
  }
}
