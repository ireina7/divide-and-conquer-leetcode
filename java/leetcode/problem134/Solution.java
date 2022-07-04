package leetcode.problem134;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/gas-station/");
    }
    public abstract int canCompleteCircuit(int[] gas, int[] cost);
}
