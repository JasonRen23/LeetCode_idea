package LeetCode_idea.String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        String pre = strs[0];
        for(int i = 1; i < strs.length; ++i){
            while(strs[i].indexOf(pre) != 0) //返回指定字符在字符串第一次出现处的索引，如果此字符中没有这样的字符，则返回-1
                pre = pre.substring(0, pre.length() - 1);
        }

        return pre;
    }

    public static void main(String[] args) {
        String[] strs1 = {"ABCD", "ABEF", "ACEF"};
        System.out.println("The LCP of strs1 is " + longestCommonPrefix(strs1)); // A

        String[] strs2 = {"ABCDEFG", "ABCEFG", "ABCEFA"};
        System.out.println("The LCP of strs2 is " + longestCommonPrefix(strs2)); // ABC

        String[] strs3 = {"ABC"};
        System.out.println("The LCP of strs3 is " + longestCommonPrefix(strs3)); // ABC

        String[] strs4 = {"A", "A"};
        System.out.println("The LCP of strs4 is " + longestCommonPrefix(strs4)); // A

    }
}
