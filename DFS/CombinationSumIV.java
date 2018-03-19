package LeetCode_idea.DFS;


import java.util.Arrays;

public class CombinationSumIV {
    //Time Exceeded
//    public static int combinationSum4(int[] nums, int target){
//        if(nums == null || nums.length < 1) return 0;
//        if(target == 0) return 1;
//        int ret = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(target >= nums[i]){
//                ret += combinationSum4(nums, target - nums[i]);
//            }
//        }
//        return ret;
//    }

    public static int combinationSum4(int[] nums, int target){
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, dp, target);
    }

    public static int helper(int[] nums, int[] dp, int target){
        if(dp[target] != -1)
            return dp[target];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i]){
                res += helper(nums, dp, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums, 4)); //7
    }
}
