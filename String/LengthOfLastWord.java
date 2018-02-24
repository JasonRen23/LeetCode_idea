package LeetCode_idea.String;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s){
        if((s.length() < 1)) return 0;

        int lastIndex = s.length() - 1;
        while(lastIndex > 0 && s.charAt(lastIndex) == ' ') lastIndex--;
        int leftIndex = lastIndex;
        while(leftIndex >= 0 && s.charAt(leftIndex) != ' ') leftIndex --;
        return lastIndex - leftIndex;
    }


    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "We Are the one";
        String str3 = "Rzc";

        System.out.println(lengthOfLastWord(str1));
        System.out.println(lengthOfLastWord(str2));
        System.out.println(lengthOfLastWord(str3));

        System.out.println(lengthOfLastWord(""));

    }
}
