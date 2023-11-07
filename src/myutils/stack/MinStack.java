package myutils.stack;

/**
 * https://leetcode.com/problems/min-stack/
 * Idea: implement the MinStack using an auxiliary stack to keep track of the minimum elements.
 * Note: constrains -> Methods pop, top and getMin operations will always be called on non-empty stacks.
 */

public class MinStack {
    int[] stack;
    int[] minStack;
    int pStack, pMinSt;                    // pointer
    public MinStack() {
        stack = new int[30001];
        minStack = new int[30001];
        pStack = 0;
        pMinSt = 0;
    }

    public void push(int val) {
        stack[pStack] = val;
        pStack ++;
        if (pMinSt == 0 || val <= minStack[pMinSt-1]) {
            minStack[pMinSt] = val;
            pMinSt ++;
        }
    }

    public void pop() {
        int last = stack[pStack-1];
        int min = minStack[pMinSt-1];
        if (last == min) {
            pMinSt --;
        }
        pStack --;
    }

    public int top() {
        return stack[pStack-1];
    }

    public int getMin() {
        return minStack[pMinSt-1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
