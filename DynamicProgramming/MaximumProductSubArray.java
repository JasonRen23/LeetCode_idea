package LeetCode_idea.DynamicProgramming;

public class MaximumProductSubArray {
    public static int maxProduct_1(int[] nums){
        if(nums.length <= 0)return 0;

        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            int temp = curMax;
           curMax = Math.max(Math.max(nums[i], curMax * nums[i]), curMin * nums[i]);
           curMin = Math.min(Math.min(nums[i], curMin * nums[i]), temp * nums[i]);
           globalMax = Math.max(curMax, globalMax);

        }

        return globalMax;

    }

    public static int maxProduct_2(int[] nums){
        if(nums.length <= 0) return 0;

        int curMax = nums[0];
        int curMin = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; ++i){
            if(nums[i] < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(nums[i], nums[i] * curMax);
            curMin = Math.min(nums[i], nums[i] * curMin);
            globalMax = Math.max(globalMax, curMax);

        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct_1(nums));
        System.out.println(maxProduct_2(nums));
    }
}
