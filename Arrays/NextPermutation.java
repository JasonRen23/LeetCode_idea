package LeetCode_idea.Arrays;

import java.util.Arrays;

public class NextPermutation {
    private static void nextPermutation(int[] nums, int begin, int end) {
        if(nums == null || nums.length < 2) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);

    }
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        nextPermutation(nums1,0, nums1.length);
        System.out.println("The array after permutation is " + Arrays.toString(nums1));

        int[] nums2 = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation(nums2,0, nums2.length);
        System.out.println("The array after permutation is " + Arrays.toString(nums2));
    }
}
