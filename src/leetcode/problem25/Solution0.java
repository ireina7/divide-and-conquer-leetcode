package leetcode.problem25;
import java.util.*;
import java.util.function.Function;

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

public class Solution0 {
    ListNode reverse(ListNode head, int k) {
        return null;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }
}

//abstract class MIO<D, E, A> {
//    public <D1, D extends D1, E1 extends E, B>
//    MIO<D1, E1, B> flatMap(Function<A, MIO<D1, E1, B>> f) {
//        return null;
//    }
//    public <A1 extends A>
//    MIO<D, E, A1> widen() {
//        return null;
//    }
//}











