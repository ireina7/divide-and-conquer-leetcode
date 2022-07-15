package leetcode.offer2.problem37;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> ctx = new LinkedList<>();
        for (int i = 0; i < asteroids.length; ++i) {
            if (ctx.isEmpty()) {
                ctx.add(asteroids[i]);
            } else {
                while (!ctx.isEmpty() && ctx.peek() > 0 &&  asteroids[i] < 0 && Math.abs(asteroids[i]) > Math.abs(ctx.peek())) {
                    ctx.pop();
                }
                if (!ctx.isEmpty() && ctx.peek() > 0 && asteroids[i] < 0 && Math.abs(asteroids[i]) == Math.abs(ctx.peek())) {
                    ctx.pop();
                    continue;
                }
                if (ctx.isEmpty() || !(ctx.peek() > 0 &&  asteroids[i] < 0 && Math.abs(asteroids[i]) < Math.abs(ctx.peek()))) {
                    ctx.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[ctx.size()];
        for (int i = ctx.size() - 1; i >= 0; --i) {
            ans[i] = ctx.pop();
        }
        return ans;
    }
}
