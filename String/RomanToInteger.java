package LeetCode_idea.String;

public class RomanToInteger {
    public static int romanToInt(String s){
        int num = 0;
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; ++i){
           if(i > 0 && map(arr[i]) > map(arr[i - 1])){
               num += (map(arr[i]) - 2 * map(arr[i - 1]));
           } else{
               num += map(arr[i]);
           }
        }

        return num;
    }

    private static int map(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCCXVI"));
    }
}
