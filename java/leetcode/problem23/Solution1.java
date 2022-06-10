package leetcode.problem23;
import java.util.*;

public class Solution1 {
    ListNode[] lists;
    ListNode merge2Lists(ListNode l1, ListNode l2) {
        var vhead = new ListNode(-1);
        var p = vhead;
        var p1 = l1;
        var p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null) {
            p.next = p1;
        }
        if(p2 != null) {
            p.next = p2;
        }
        return vhead.next;
    }
    ListNode
    merge(int i, int j) {
        switch (j - i) {
            case 0: return null;
            case 1: return lists[i];
            case 2: return merge2Lists(lists[i], lists[i + 1]);
            default:
                int k = (i + j - 1) / 2;
                var l1 = merge(i, k);
                var l2 = merge(k, j);
                return merge2Lists(l1, l2);
        }
    }
    
    public ListNode
    mergeKLists(ListNode[] lists) {
        this.lists = lists;
        return merge(0, lists.length);
    }
}
