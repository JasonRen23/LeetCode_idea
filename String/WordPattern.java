package LeetCode_idea.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str){
        if(pattern.length() < 1 || str.length() < 1)return false;

        String[] arr = str.split(" ");
        if(pattern.length() != arr.length)return false;

        Map<String, Character> stringMap = new HashMap<>();
        Map<Character, String> patternMap = new HashMap<>();

        for(int i = 0; i < pattern.length(); ++i){
            char ch = pattern.charAt(i);
            if(stringMap.containsKey(arr[i])){
                if(stringMap.get(arr[i]).compareTo(ch) == -1)
                    return false;
            }else {
                stringMap.put(arr[i], ch);
            }

            if(patternMap.containsKey(ch)){
                if(!patternMap.get(ch).equals(arr[i]))
                    return false;
            }else {
                patternMap.put(ch, arr[i]);
            }

        }
        return true;
    }


    public static boolean wordPattern_1(String pattern, String str){
        String[] map = new String[256];
        Set<String> set = new HashSet<>();
        final int n = pattern.length();
        int i = 0, j = 0;
        while (i < n){
            int k = j;
            while (k < str.length() && str.charAt(k) != ' ') k++;
            if(k == j)return false;
            char x = pattern.charAt(i);
            String word = str.substring(j, k);
            if(map[x] != null && !map[x].equals(word)) return false;
            else if(map[x] == null && set.contains(word)) return false;
            else if(map[x] == null){
                map[x] = word;
                set.add(word);
            }
            i++;
            j = k;
            while (j <str.length() && str.charAt(j) == ' ') j++;
        }
        return (i == n && j == str.length());

    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); //true
        System.out.println(wordPattern_1("abba", "dog cat cat dog")); //true
        System.out.println(wordPattern("abba", "dog cat cat fish"));//false
        System.out.println(wordPattern_1("abba", "dog cat cat fish"));//false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); //false
        System.out.println(wordPattern_1("aaaa", "dog cat cat dog")); //false
        System.out.println(wordPattern("abba", "dog dog dog dog")); //false
        System.out.println(wordPattern_1("abba", "dog dog dog dog")); //false
    }
}
