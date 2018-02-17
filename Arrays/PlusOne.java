package LeetCode_idea.Arrays;

import java.util.Arrays;

public class PlusOne {
   public static int[] plusOne(int[] digits){
       int N = digits.length;
       for(int i = N - 1; i >= 0; --i){
           if(digits[i] != 9){
               digits[i]++;
               return digits;
           }
           digits[i] = 0;
       }
       int[] num = new int[N + 1];
       num[0] = 1;
       return num;
   }

    public static void main(String[] args) {
        int[] nums1 = {9, 9, 9};
        System.out.println("The plusone ret of nums1 is " + Arrays.toString(plusOne(nums1)));

        int[] nums2 = {1, 9, 9};
        System.out.println("The plusone ret of nums2 is " + Arrays.toString(plusOne(nums2)));    }
}
