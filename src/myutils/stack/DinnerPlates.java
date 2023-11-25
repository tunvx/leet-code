package myutils.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/dinner-plate-stacks/
 * Idea: Use treeset store all pushable stacks
 */

public class DinnerPlates {
    List<Stack<Integer>> listStack = new ArrayList<Stack<Integer>>();
    TreeSet<Integer> pushableStack = new TreeSet<Integer>();
    private int maxSize;

    public DinnerPlates(int capacity) {
        listStack.clear();
        pushableStack.clear();
        maxSize = capacity;
    }

    public void push(int val) {
        if (pushableStack.isEmpty()) {
            listStack.add(new Stack<Integer>());
            pushableStack.add(listStack.size() - 1);
        }

        int firstIndex = pushableStack.first();
        listStack.get(firstIndex).push(val);

        if (listStack.get(firstIndex).size() == maxSize) {
            pushableStack.remove(firstIndex);
        }
    }

    public int pop() {
        int lastIndex = listStack.size()-1;

        // remove all last empty stack;
        while (lastIndex > 0 && listStack.get(lastIndex).isEmpty()) {
            listStack.remove(lastIndex);
            pushableStack.remove(lastIndex);
            lastIndex --;
        }
        return popAtStack(lastIndex);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= listStack.size() ) {
            return -1;
        }
        if (listStack.get(index).isEmpty()) {
            return -1;
        }
        int res = listStack.get(index).pop();
        pushableStack.add(index);
        return res;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
