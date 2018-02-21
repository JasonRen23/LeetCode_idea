package LeetCode_idea.String;

public class LongestPalindrome {

    // Two pointers
    public static String longestPalindrome_1(String s){
        if(s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
           int len1 = expand(s, i, i);
           int len2 = expand(s, i,i + 1);
           int len = Math.max(len1, len2);
           if(len > end - start + 1){
               start = i - (len - 1) / 2;
               end = i + len / 2;
           }
        }
        return s.substring(start, end + 1);
    }
    public static int expand(String s, int lo, int hi){
        while(lo >=0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
            lo--;
            hi++;
        }
        return hi - lo - 1;
    }

    // Dynamic programming
    public static String longestPalindrome_2(String s){
        if(s == null || s.length() < 1) return "";
        final int n = s.length();
        boolean f[][] = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for(int i = 0; i < n; ++i){
            f[i][i] = true;
            for(int j = 0; j < i; ++j){
               f[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || f[j + 1][i - 1]));
               if(f[j][i] && i - j + 1 > maxLen){
                   maxLen = i - j + 1;
                   start = j;
               }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Manacher
//    public static String longestPalindrome_3(String s){
//
//    }

    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("The ret is " + longestPalindrome_1(s1));
        System.out.println("The ret is " + longestPalindrome_2(s1));
//        System.out.println("The ret is " + longestPalindrome_3(s1));

    }
}
