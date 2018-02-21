package LeetCode_idea.String;

public class StrStr {
    public static int strStr(String haystack, String needle){
        if(haystack.length() < needle.length()) return -1;
        int hPointer, nPointer;
        final int N = haystack.length() - needle.length() + 1;
        for(int i = 0; i < N; ++i){
            hPointer = i;
            nPointer = 0;
            while(hPointer < haystack.length() && nPointer < needle.length() &&
                    haystack.charAt(hPointer) == needle.charAt(nPointer)){
                hPointer++;
                nPointer++;
            }
            if(nPointer == needle.length()) return i;
        }

        return -1;
    }

    public static int strStr_2(String haystack, String needle){
        return haystack.indexOf(needle);
    }

    public static int strStr_3(String haystack, String needle){
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); ++i){
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("The output is " + strStr(haystack1, needle1));//2
        System.out.println("The output is " + strStr_2(haystack1, needle1));//2
        System.out.println("The output is " + strStr_3(haystack1, needle1));//2


        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("The output is " + strStr(haystack2, needle2));//-1
        System.out.println("The output is " + strStr_2(haystack2, needle2));//-1
        System.out.println("The output is " + strStr_3(haystack2, needle2));//-1
    }
}
