package leetcode.problem16;
import java.util.*;
import java.util.stream.Stream;

public class Solution0 {
  public int threeSumClosest(int[] nums, int target) {
    if(nums.length < 3) return 0;
    Arrays.sort(nums);
    int ans = Arrays.stream(nums).limit(3).reduce(0, (a, b) -> a + b);
    for(int k = 0; k < nums.length - 2; ++k) {
      int i = k + 1;
      int j = nums.length - 1;
      while(i < j) {
        int sum = nums[i] + nums[j];
        if(Math.abs(ans - target) > Math.abs(sum + nums[k] - target)) {
          ans = sum + nums[k];
        }
        if(sum == target - nums[k]) {
          return target;
        } else if(sum < target - nums[k]) {
          i += 1;
        } else {
          j -= 1;
        }
      }
    }
    return ans;
  }
}
