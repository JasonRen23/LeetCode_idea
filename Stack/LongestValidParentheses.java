package LeetCode_idea.Stack;


import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses_1(String s){
        if(s.length() < 2) return 0;

        final int n =s.length();
        int maxLen = 0, last = -1;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                 last = i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(i - last, maxLen);
                    }else {
                        maxLen = Math.max(i - stack.peek(), maxLen);
                    }
                }
            }
        }
        return maxLen;
    }

    public static int longestValidParentheses_2(String s){
        if(s.length() < 2) return 0;
        final int n = s.length();
        int[] longest = new int[n + 1];

        for(int i = 1; i < n; ++i){
            if(s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '('){
                longest[i] = longest[i - 1] + 2 + (i - longest[i - 1] - 2 >= 0
                        ? longest[i - longest[i - 1] -2] : 0);
                longest[n] = Math.max(longest[n], longest[i]);
            }
        }
        return longest[n];

    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses_1("()()"));
        System.out.println(longestValidParentheses_1("(()"));
        System.out.println(longestValidParentheses_1("()(()"));
        System.out.println(longestValidParentheses_1(")("));
        System.out.println(longestValidParentheses_1("()(())"));

        System.out.println();

        System.out.println(longestValidParentheses_2("()()"));
        System.out.println(longestValidParentheses_2("(()"));
        System.out.println(longestValidParentheses_2("()(()"));
        System.out.println(longestValidParentheses_2(")("));
        System.out.println(longestValidParentheses_2("()(())"));

        System.out.println(longestValidParentheses_2("())"));
    }
}
