package LeetCode_idea.Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        dataStack.push(x);
        int minValue = minStack.isEmpty() ? x : Math.min(x, minStack.peek());
        minStack.push(minValue);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
