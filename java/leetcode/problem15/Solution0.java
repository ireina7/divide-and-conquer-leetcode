package leetcode.problem15;
import java.util.*;
import java.util.stream.Collectors;

public class Solution0 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    for(int k = 0; k < nums.length - 2; ++k) {
      int i = k + 1;
      int j = nums.length - 1;
      while(i < j) {
        int sum = nums[i] + nums[j];
        if(sum == -nums[k]) {
          List<Integer> triple = new ArrayList<>();
          triple.add(nums[k]);
          triple.add(nums[i]);
          triple.add(nums[j]);
          set.add(triple);
          i += 1;
          j -= 1;
        } else if(sum < -nums[k]) {
          i += 1;
        } else {
          j -= 1;
        }
      }
    }
    return set.stream().collect(Collectors.toList());
  }
}
