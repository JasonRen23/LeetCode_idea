package LeetCode_idea.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static boolean isIsmorphic_1(String s, String t){
        if(s.length() != t.length()) return false;

        int[] stringMap1 = new int[256];
        int[] stringMap2 = new int[256];
        final int n = s.length();
        for(int i = 0; i < n; ++i){
            int ss = (int) s.charAt(i);
            int tt = (int) t.charAt(i);
            if(stringMap1[ss] != stringMap2[tt]) return false;
            stringMap1[ss] = i + 1;
            stringMap2[tt] = i + 1;
        }
        return true;
    }


    public static boolean isIsmorphic_2(String s, String t){
        if(s.length() != t.length()) return false;
        final Map<Character, Character> map1 = new HashMap<>();
        final Map<Character, Character> map2 = new HashMap<>();

        final int n = s.length();
        for(int i = 0; i < n; ++i){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2)
                    return false;
            }else {
                map1.put(c1, c2);
            }

            if(map2.containsKey(c2)){
                if(map2.get(c2) != c1)
                    return false;
            }else {
                map2.put(c2, c1);
            }

        }
        return true;
    }


    public static boolean isIsmorphic_3(String s, String t){
        if(s.length() != t.length()) return false;

        int[] stringMap = new int[256];
        Arrays.fill(stringMap,-1);
        final int n = s.length();

        for(int i =0; i < n; ++i){
            int ss = (int) s.charAt(i);
            int tt = (int) t.charAt(i);
            if(stringMap[ss] == -1 && stringMap[tt] == -1) {
                stringMap[ss] = tt;
                stringMap[tt] = ss;
            }
            else if (stringMap[ss] != tt || stringMap[tt] != ss) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2= "foo",  t2 = "bar";
        String s3 = "paper", t3 = "title";

        System.out.println(isIsmorphic_1(s1, t1)); //true
        System.out.println(isIsmorphic_2(s1, t1)); //true

        System.out.println();

        System.out.println(isIsmorphic_1(s2, t2)); //false
        System.out.println(isIsmorphic_2(s2, t2)); //false

        System.out.println();

        System.out.println(isIsmorphic_1(s3, t3)); //true
        System.out.println(isIsmorphic_2(s3, t3)); //true



    }
}
