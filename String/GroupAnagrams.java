package LeetCode_idea.String;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs == null) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> group = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);
            List<String> list;
            if(group.containsKey(key)){
                list = group.get(key);
            }else{
                list = new ArrayList<String>();
                res.add(list);
                group.put(key, list);
            }
            list.add(str);
        }

        return res;
    }

    public static List<List<String>> groupAnagrams_2(String[] strs){
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0){
            return result;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};


        Map<Integer, List<String>> map = new HashMap<Integer,List<String>>();
        for (String st: strs) {
            char[] str = st.toCharArray();
            int key = 1;
            for (int i = 0; i < str.length; i++) {

                key *= prime[str[i]-'a'];
            }
            List<String> list;
            if (map.containsKey(key)){
                list = map.get(key);
            } else {
                list = new ArrayList<String>();
                result.add(list);
                map.put(key,list);
            }
            list.add(st);

        }
        return result;


    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.asList(groupAnagrams(strs)));
        System.out.println(Arrays.asList(groupAnagrams_2(strs)));
    }
}
