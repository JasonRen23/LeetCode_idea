package LeetCode_idea.Stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){

        final String left = "([{";
        final String right = ")]}";

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(left.indexOf(ch) != -1 || stack.isEmpty()) stack.push(ch);
            else if(stack.peek() == left.charAt(right.indexOf(ch))) stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("){"));
    }
}
