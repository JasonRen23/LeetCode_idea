package LeetCode_idea.String;

public class WildcardMatching {
    public static boolean isMatch(String s, String p){
        if(s.equals(p)) return true;
        if(s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for(int i = 1; i < dp.length; ++i){
            dp[i][0] = false;
        }

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

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); //false
        System.out.println(isMatch("aa", "aa")); //true
        System.out.println(isMatch("aaa", "aa")); //false
        System.out.println(isMatch("aa", "*")); //true
        System.out.println(isMatch("aa", "a*")); //true
        System.out.println(isMatch("ab", "?*")); //true
        System.out.println(isMatch("aab", "c*a*b")); //false
    }
}
