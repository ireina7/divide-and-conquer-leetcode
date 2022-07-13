package leetcode.offer2.problem28;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/Qv1Da2/");
    }
    public abstract Node flatten(Node head);
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};