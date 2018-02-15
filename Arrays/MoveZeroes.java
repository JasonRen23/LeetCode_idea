package LeetCode_idea.Arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if(nums.length < 2) return;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums, index++, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("The array nums is " + Arrays.toString(nums));

    }
}
