package leetcode.problem1;
import java.util.Map;
import java.util.HashMap;

/** https://leetcode.cn/problems/two-sum/
 * */
public class Solution0 {

    /**
      * This dividing is simple:
      [-------------------x]
                ||
                V
      [------------------] x
      Just get the last one, and if we can get solution of the `initial` part
      (if you know Haskell's init function, you know what 'initial' is), 
      if pre@twoSum(init part) is not null
      then pre
      else check if we have seen `target - x`.
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (memo.containsKey(target - nums[i])) {
                return new int[]{memo.get(target - nums[i]), i};
            }
            memo.put(nums[i], i);
        }
        return new int[0];
    }
}