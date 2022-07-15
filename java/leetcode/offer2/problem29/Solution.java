package leetcode.offer2.problem29;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/4ueAj6/");
    }
    public abstract Node insert(Node head, int insertVal);
}

class Node {
    public int val;
    public Node next;
    
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};