package myutils.stack;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation
 * Note: ** Read constrains of this task **
 * Idea: ** Using array for implement my custom stack **
 */

public class CustomStack {
    private int[] stack;
    private int maxSize, pointer;
    public CustomStack(int maxSize) {
        this.stack = new int[1001];
        this.maxSize = maxSize;
        this.pointer = 0;
    }

    public void push(int x) {
        if (pointer == maxSize) {
            return;
        }
        stack[pointer] = x;
        pointer += 1;
    }

    public int pop() {
        if (pointer == 0) {
            return -1;
        }
        int res = stack[pointer-1];
        pointer -= 1;
        return res;
    }

    public void increment(int k, int val) {
        if (k > pointer) {
            k = pointer;
        }
        for (int i=0; i < k; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
