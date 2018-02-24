package LeetCode_idea.Stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer>q;
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        for(int i = 1; i < q.size(); ++i){
            q.add(q.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
       return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return q.isEmpty();
    }



    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        System.out.println(st.top());
        st.push(3);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
    }
}
