package LeetCode_idea.Middle_2025.bytedance;

/**
 *
 * 力扣5. 最长回文子串
 * @author RenZhiCheng
 * @since 2025/2/1 01:04
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        char[] ss = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (ss[i] == ss[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        begin = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); //bab
    }
}
