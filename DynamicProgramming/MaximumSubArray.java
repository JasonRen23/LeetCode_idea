package LeetCode_idea.DynamicProgramming;

public class MaximumSubArray {
    public static int maxSubArray(int[] nums){
        if(nums.length <= 0) return 0;


        int curSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; ++i){
           curSum = Math.max(nums[i], nums[i] + curSum);
           maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
