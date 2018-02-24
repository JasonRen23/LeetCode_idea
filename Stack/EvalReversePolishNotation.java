package LeetCode_idea.Stack;

import java.util.Stack;

public class EvalReversePolishNotation {
    public static int evalRPN_1(String[] tokens){
        Stack<String> s = new Stack<>();
        final String exp = "+-*/";
        int ret;
        for(String token : tokens){
            if(exp.contains(token)){
                int num2 = Integer.valueOf(s.pop());
                int num1 = Integer.valueOf(s.pop());
                ret = cal(num1, num2, token);
                s.push(String.valueOf(ret));
            }else {
                s.push(token);
            }
        }
        return Integer.parseInt(s.peek());
    }

    private static int curr;
    private static String exp;
    public static int evalRPN_2(String[] tokens){
        curr = tokens.length - 1;
        exp = "+-*/";
        return eval(tokens);
    }

    public static int eval(String[] tokens){
        String token = tokens[curr--];
        if(token.length() == 1 && exp.contains(token)){
            int b = eval(tokens);
            int a= eval(tokens);
            return cal(a, b, token);
        }else {
            return Integer.parseInt(token);
        }
    }

    public static int cal(int num1, int num2, String exp){
        switch (exp){
            case "*": return num1 * num2;
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "/": return num1 / num2;
            default: return 0;
        }
    }


    public static int evalRPN_3(String[] tokens){
        Stack<Integer> st = new Stack<>();
        int num1 = 0, num2 = 0;
        for(String token : tokens){
            switch(token){
                case "+":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 + num2);
                    break;
                case "-":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 - num2);
                    break;
                case "*":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 * num2);
                    break;
                case "/":
                    num2 = st.pop();
                    num1 = st.pop();
                    st.push(num1 / num2);
                    break;
                default:
                    st.push(Integer.parseInt(token));
                    break;
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String[] str1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN_1(str1));
        System.out.println(evalRPN_2(str1));
        System.out.println(evalRPN_3(str1));

        String[] str2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN_1(str2));
        System.out.println(evalRPN_2(str2));
        System.out.println(evalRPN_3(str2));
    }
}
