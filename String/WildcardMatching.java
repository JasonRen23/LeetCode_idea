package LeetCode_idea.String;

public class WildcardMatching {
    // 2d dp
    public static boolean isMatch(String s, String p){
        if(s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;


        for(int j = 1; j < dp[0].length; ++j){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }

        for(int i = 1; i < dp.length; ++i){
            for(int j = 1; j < dp[0].length; ++j){
                if(p.charAt(j - 1) != '*' ){
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    // pointers

    public static boolean isMatch_1(String s, String p){
        if(s == null || p == null) return false;
        int i = 0, stringIndex = -1, j = 0, starIndex = -1;

        while(i < s.length()){
            if(j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))){
                i++;
                j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                stringIndex = i;
                starIndex = j;
                j++;
            }else if(starIndex != -1){
                j = starIndex + 1;
                i = stringIndex + 1;
                stringIndex++;
            }else return false;

        }

        while(j < p.length() && p.charAt(j) == '*') j++;

        return j == p.length();


    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); //false
        System.out.println(isMatch("aa", "aa")); //true
        System.out.println(isMatch("aaa", "aa")); //false
        System.out.println(isMatch("aa", "*")); //true
        System.out.println(isMatch("aa", "a*")); //true
        System.out.println(isMatch("ab", "?*")); //true
        System.out.println(isMatch("aab", "c*a*b")); //false

        System.out.println();

        System.out.println(isMatch_1("aa", "a")); //false
        System.out.println(isMatch_1("aa", "aa")); //true
        System.out.println(isMatch_1("aaa", "aa")); //false
        System.out.println(isMatch_1("aa", "*")); //true
        System.out.println(isMatch_1("aa", "a*")); //true
        System.out.println(isMatch_1("ab", "?*")); //true
        System.out.println(isMatch_1("aab", "c*a*b")); //false
        System.out.println(isMatch_1("aabc", "a*bc")); //false
    }
}
