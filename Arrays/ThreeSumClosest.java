package LeetCode_idea.Arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target){
        if(nums == null || nums.length < 3) return -1;
        int res = nums[0] + nums[1] + nums[2];
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            if(i == 0 || (nums[i] < target && nums[i] != nums[i - 1])){
                int lo = i + 1, hi = nums.length - 1;
                while(lo < hi){
                    //if(sum == target) return sum;
                    sum = nums[lo] + nums[hi] + nums[i];
                    if(Math.abs(res - target) >= Math.abs(sum - target)){
                        res = sum;
                        if(res == target) return res;
                    }
                    if(sum < target){
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        lo++;
                    }else{
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        System.out.println("The sum that is closest to the target is " + threeSumClosest(nums1, 1));

        int[] nums2 = {0, 2, 1, -3};
        System.out.println("The sum that is closest to the target is " + threeSumClosest(nums2, 1));    }
}
