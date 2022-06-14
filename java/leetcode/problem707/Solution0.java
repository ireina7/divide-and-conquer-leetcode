package leetcode.problem707;
import java.util.*;

public class Solution0 {
    public Solution0() {
        System.out.println("See design of class MyLinkedList.");
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {
    static class Node {
        public int val;
        public Node next;
        public Node() {
            val = 0;
            next = null;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    Node head;
    int length;
    
    public MyLinkedList() {
        this.head = new Node(-1, null);
    }
    public int get(int index) {
        Node cur = head;
        for(int i = 0; i <= index; ++i) {
            if(cur == null) return -1;
            cur = cur.next;
        }
        return cur == null ? -1 : cur.val;
    }
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }
    public void addAtIndex(int index, int val) {
        Node cur = head;
        for(int i = 0; i < index; ++i) {
            if(cur == null) return;
            cur = cur.next;
        }
        if(cur == null) return;
        cur.next = new Node(val, cur.next);
        length += 1;
    }
    public void deleteAtIndex(int index) {
        Node cur = head;
        for(int i = 0; i < index; ++i) {
            if(cur == null) return;
            cur = cur.next;
        }
        if(cur == null || cur.next == null) {
            return;
        }
        cur.next = cur.next.next;
        length -= 1;
    }
    protected void debug() {
        Node cur = head;
        while(cur != null) {
            System.out.printf("%d, ", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }
}

