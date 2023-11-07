package myutils.stack;

/**
 * https://leetcode.com/problems/implement-stack-using-queues
 * Idea: ** -.- **
 */

import java.util.ArrayDeque;
import java.util.Queue;
// LIFO - Last In First Out
public class MyStack {
    private Queue<Integer> q1 = new ArrayDeque<>(); // FIFO
    private Queue<Integer> q2 = new ArrayDeque<>(); // FIFO
    public MyStack() {
        q1.clear();
        q2.clear();
    }

    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
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
