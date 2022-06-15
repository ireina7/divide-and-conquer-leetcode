package leetcode.problem225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0 {
    public Solution0() {
        System.out.println("This is a design problem, see code below.");
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        int n1 = queue1.size();
        for(int i = 1; i < n1; ++i) {
            queue2.offer(queue1.poll());
        }
        int ans = queue1.poll();
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return ans;
    }
    
    public int top() {
        int n1 = queue1.size();
        for(int i = 1; i < n1; ++i) {
            queue2.offer(queue1.poll());
        }
        int ans = queue1.poll();
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        queue1.add(ans);
        return ans;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

