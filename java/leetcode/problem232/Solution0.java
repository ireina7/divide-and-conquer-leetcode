package leetcode.problem232;

import java.util.Stack;

public class Solution0 {
    public Solution0() {
        System.out.println("This is a design problem, see code below.");
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    Stack<Integer> stkIn;
    Stack<Integer> stkOut;
    
    public MyQueue() {
        stkIn = new Stack<>();
        stkOut = new Stack<>();
    }
    
    public void push(int x) {
        stkIn.push(x);
    }
    
    public int pop() {
        if(!stkOut.isEmpty()) return stkOut.pop();
        move();
        return stkOut.pop();
    }
    
    public int peek() {
        if(!stkOut.isEmpty()) return stkOut.peek();
        move();
        return stkOut.peek();
    }
    
    public boolean empty() {
        return stkOut.isEmpty() && stkIn.isEmpty();
    }
    
    private void move() {
        while(!stkIn.isEmpty()) {
            stkOut.push(stkIn.pop());
        }
    }
}
