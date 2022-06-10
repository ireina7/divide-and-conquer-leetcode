package leetcode.problem23;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * */
public class Solution0 {
    ListNode merge(List<ListNode> xs) {
        if(xs.isEmpty()) {
            return null;
        }
        int minIndex = 0;
        ListNode minNode = xs.get(0);
        for(int i = 0; i < xs.size(); ++i) {
            var node = xs.get(i);
            if(node.val < minNode.val) {
                minNode = node;
                minIndex = i;
            }
        }
        xs.set(minIndex, minNode.next);
        minNode.next =
            merge(xs.stream().filter(x -> x != null).collect(Collectors.toList()));
        return minNode;
    }
    public ListNode
    mergeKLists(ListNode[] lists) {
        return merge(
            new ArrayList<>(
                Arrays.stream(lists).filter(n -> n != null).collect(Collectors.toList())
            )
        );
    }
}








