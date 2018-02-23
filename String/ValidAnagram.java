package LeetCode_idea.String;


public class ValidAnagram {
    public static boolean isAnagram(String s, String t){
        if(s == null || t == null || s.length() != t.length()) return false;
        int[] tables = new int[26];
        for(int i = 0; i < s.length(); ++i){
            tables[s.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < t.length(); ++i){
            tables[t.charAt(i) - 'a'] -= 1;
        }

        return checkAllZeros(tables);

    }

    public static boolean checkAllZeros(int[] nums){
        for (int num : nums){
            if(num != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram";
        System.out.println(isAnagram(s1, t1));

        String s2 = "rat", t2 = "car";
        System.out.println(isAnagram(s2, t2));
    }
}
