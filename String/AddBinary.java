package LeetCode_idea.String;

public class AddBinary {
    public static String addBinary(String a, String b){
        StringBuilder res = new StringBuilder();
        if(a.length() < 1) return b;
        if(b.length() < 1) return a;

        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

       while(i >= 0 || j >= 0 || carry > 0){
           int valueA = i < 0 ? 0 : a.charAt(i--) - '0';
           int valueB = j < 0 ? 0 : b.charAt(j--) - '0';

           int sum = valueA + valueB + carry;
           carry = sum / 2;
           res.insert(0, Character.forDigit(sum % 2, 10));


       }

       return res.toString();

    }




   public static void main(String[] args) {
        String s1 = "11", s2 = "1";
        System.out.println(addBinary(s1, s2));

        String s3 = "1111", s4 = "1111";
        System.out.println(addBinary(s3, s4));
    }
}
