package LeetCode_idea.Middle_2025.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * @author RenZhiCheng
 * @since 2025/2/18 00:52
 */
public class ValidBrackets {

    public static boolean isValid(String s) {
       int n = s.length();
       if (n % 2 == 1) {
           return false;
       }
       Map<Character, Character> pairs = new HashMap<Character, Character>() {
           {
               put(')', '(');
               put(']', '[');
               put('}', '{');
           }
       };
       Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()"; // true
        System.out.println(isValid(s1));
        String s2 = "([])"; // true
        System.out.println(isValid(s2));
        String s3 = "(]"; // false
        System.out.println(isValid(s3));
        String s4 = "([])"; // true
        System.out.println(isValid(s4));
        String s5 = "]"; // false
        System.out.println(isValid(s5));
        String s6 = "))"; // false
        System.out.println(isValid(s6));
    }
}
