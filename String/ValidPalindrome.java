package LeetCode_idea.String;

public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        if(s == null || s.length() < 2) return true;
        int n = s.length();
        int lo = 0, hi = n - 1;
        while(lo < hi){
            if(!Character.isLetterOrDigit(s.charAt(lo))) ++lo;
            else if(!Character.isLetterOrDigit(s.charAt(hi))) -- hi;
            else if(getLowerCase(s, lo) != getLowerCase(s, hi)) return false;
            else{++lo; --hi;}
        }
        return true;
    }

    private static char getLowerCase(String s, int index){
        char ch = s.charAt(index);
        if(ch >= 'A' && ch <= 'Z'){
            return (char) (ch - 'A' + 'a');
        }
        return ch;
    }


    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("The string is palindrome : " + isPalindrome(s1));

        String s2 = "race a car";
        System.out.println("The string is palindrome : " + isPalindrome(s2));
    }
}
