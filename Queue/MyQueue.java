package LeetCode_idea.Queue;

import java.util.Stack;

public class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       peek();
       return st2.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(!st2.isEmpty()){
            return st2.peek();
        }else {
            while (st1.size() > 0){
                st2.push(st1.pop());
            }
            return st2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue que = new MyQueue();
        que.push(1);
        que.push(2);
        System.out.println(que.pop());
        que.push(3);
        System.out.println(que.peek());
        System.out.println(que.empty());
    }
}
