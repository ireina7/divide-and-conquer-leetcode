package leetcode.offer2.problem23;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/3u1WK4/");
    }
    public abstract ListNode getIntersectionNode(ListNode headA, ListNode headB);
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}