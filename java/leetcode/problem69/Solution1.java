package leetcode.problem69;
import java.util.*;

public class Solution1 {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int i = 1, j = x;
        while (i <= j) {
            int k = i + ((j - i) >> 1);
            if(k == x / k) return k;
            if(k < x / k) i = k + 1;
            else j = k - 1;
        }
        return j;
    }
}
