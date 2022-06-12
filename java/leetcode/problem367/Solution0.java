package leetcode.problem367;
import java.util.*;

public class Solution0 {
    public boolean isPerfectSquare(int num) {
        if(num <= 1) return true;
        int i = 1, j = num;
        while (i <= j) {
            int k = i + ((j - i) >> 1);
            if((num % k) == 0 && k == num / k) return true;
            if(k < num / k) i = k + 1;
            else j = k - 1;
        }
        return (num / j) == j;
    }
}
