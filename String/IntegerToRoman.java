package LeetCode_idea.String;

public class IntegerToRoman {
    public static String intToRoman(int num){
        final int radix[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for(int i =0; num > 0; ++i){
           while(num >= radix[i]){
               roman.append(symbol[i]);
               num -= radix[i];
           }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3216));
    }
}
