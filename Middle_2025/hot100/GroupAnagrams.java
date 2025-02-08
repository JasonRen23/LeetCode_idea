package LeetCode_idea.Middle_2025.hot100;

import java.util.*;
/**
 * 49. 字母异位词分组
 * @author RenZhiCheng
 * @since 2025/2/8 10:58
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return new ArrayList<>();
        }
        if (strs.length == 1) {
            List<List<String>> list = new ArrayList<>();
            List<String> subList = new ArrayList<>();
            list.add(subList);
            subList.add(strs[0]);
            return list;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] code = new int[26];
            for (int i = 0; i < str.length(); i++) {
                code[str.charAt(i) - 'a']++;
            }
            StringBuilder codeStr = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                codeStr.append(code[i]);
                codeStr.append("-");
            }
            String key = codeStr.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
