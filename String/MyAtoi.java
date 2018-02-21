package LeetCode_idea.String;

public class MyAtoi {
    public static int myAtoi(String str){
        int num = 0;
        int sign = 1;
        final int n = str.length();
        if(n == 0) return 0;

        int i = 0;
        while(i < n && str.charAt(i) == ' ')i++;

        if(str.charAt(i) == '+' || str.charAt(i) == '-'){

            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        for(; i < n; ++i){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9)
                break;
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        String s1 = "-3924x8fc", s2 = " +413", s3 = "++c", s4 = "++1", s5 = "2147483648";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
    }
}
