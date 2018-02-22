package LeetCode_idea.String;

public class CountAndSay {
    public static String countAndSay(int n){
        String ans = "1";
        for(int i = 2; i <= n; ++i){
            ans = getNext(ans);
        }
        return ans;

    }

    public static String getNext(String s){
        StringBuilder sb = new StringBuilder();

        char last = s.charAt(0);
        int count = 1;


        for(int i = 1; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == last){
                count++;
            }else{
                sb.append(count);
                sb.append(last);
                last = s.charAt(i);
                count = 1;
            }

        }
        sb.append(count);
        sb.append(last);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(4));
    }
}
