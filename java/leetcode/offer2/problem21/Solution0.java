package leetcode.offer2.problem21;

import org.w3c.dom.ls.LSException;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode();
        fake.next = head;
        ListNode i = fake;
        ListNode j = i;
        for (int d = 0; d <= n; ++d) j = j.next;
        while (j != null) {
            j = j.next;
            i = i.next;
        }
        i.next = i.next.next;
        return fake.next;
    }
}
