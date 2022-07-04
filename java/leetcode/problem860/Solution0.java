package leetcode.problem860;

import java.util.ArrayList;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Greedy";
    }
    
    int m5, m10;
    @Override
    public boolean lemonadeChange(int[] bills) {
        this.m5 = this.m10 = 0;
        for (int bill : bills) {
            if (!check(bill)) return false;
        }
        return true;
    }
    boolean check(int bill) {
        if (bill == 5) {
            m5 += 1;
            return true;
        }
        if (bill == 10) {
            if (m5 == 0) return false;
            m5 -= 1;
            m10 += 1;
            return true;
        }
        if (bill == 20) {
            if (m10 > 0 && m5 > 0) {
                m5 -= 1;
                m10 -= 1;
                return true;
            } else if (m5 >= 3) {
                m5 -= 3;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
