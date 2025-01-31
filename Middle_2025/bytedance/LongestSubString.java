package LeetCode_idea.Middle_2025.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 力扣3. 无重复字符的最长子串
 * @author RenZhiCheng
 * @since 2025/2/1 00:49
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = ss[right];
            while (set.contains(ch)) {
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
