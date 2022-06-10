package leetcode.problem18;
import java.util.*;
import java.util.stream.Stream;
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
  Stream<List<Integer>> twoSum(int i, int j, int target) {
    if(nums.size() < 2) {
      return Stream.of();
    }
    if(nums.size() == 2) {
      int sum = nums.stream()
          .limit(2)
          .reduce(0, (a, b) -> a + b);
      return sum == target ?Stream.of(nums) : Stream.of();
    }
    Set<List<Integer>> ans = new HashSet<>();
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
    return ans.stream();
  }
  /**
   * Let's do the job.
   * */
  Stream<List<Integer>> dfs(int i, int j, int target, int n) {
    if(j - i + 1 < n) return Stream.of();
    if(n <= 0) return Stream.of();
    if(n == 1) {
      return nums.contains(target)
          ? Stream.of(List.of(target)) : Stream.of();
    }
    if(n == 2) {
      return twoSum(i, j, target);
    }
    Set<List<Integer>> ans = new HashSet<>();
    for(int k = i; k <= j - n + 1; ++k) {
      final int x = nums.get(k);
      dfs(k + 1, j, target - x, n - 1)
          .forEach( xs -> {
              List<Integer> ys = new ArrayList<>(xs);
              ys.add(0, x);
              ans.add(ys);
            }
          );
    }
    return ans.stream();
  }

  /**
   * nSum application interface.
   * */
  public List<List<Integer>> nSum(List<Integer> nums, int target, int n) {
    this.nums = nums.stream()
        .sorted()
        .collect(Collectors.toList());
    return dfs(0, nums.size() - 1, target, n)
        .collect(Collectors.toList());
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
