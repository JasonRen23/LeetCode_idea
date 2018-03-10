package LeetCode_idea.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS_1(int[] nums){
        if(nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return 1;
        int maxLen = 0;
        int[] tails = new int[nums.length];
        tails[0]= nums[0];

        for(int i= 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            }else if(nums[i] > tails[maxLen]){
                tails[++maxLen] = nums[i];
            }else {
                tails[binarySearch(tails, 0, maxLen, nums[i])] = nums[i];
            }
        }
        return maxLen + 1;
    }

    static int binarySearch(int[] nums, int max, int min, int target){
        while (min <= max){
            int mid = min + (max - min) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static int lengthOfLIS_2(int[] nums){
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1)return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for(int j = 1; j < nums.length; j++){
            for(int i = 0; i < j; i++){
                if(nums[i] < nums[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[j]);
        }

        return maxLen;

    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS_1(nums));
        System.out.println(lengthOfLIS_2(nums));

    }
}
