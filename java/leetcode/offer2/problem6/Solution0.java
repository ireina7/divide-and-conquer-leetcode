package leetcode.offer2.problem6;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "divide and conquer";
    }
    
    @Override
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i, j};
            else if (sum < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return null;
    }
}
