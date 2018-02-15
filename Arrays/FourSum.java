package LeetCode_idea.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ret =new ArrayList<>();
        if(nums.length < 4) return ret;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; ++i){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            if(nums[i] * 4 > target) break; //Too big
            if(nums[i] + 3 * nums[nums.length - 1] < target) continue; //Too small
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                if(nums[j] * 3 > target - nums[i]) break; //Too big
                if(nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) continue; //Too small

                int lo = j + 1, hi = nums.length - 1;
                while(lo < hi){
                    int sum = nums[lo] + nums[hi] + nums[i] + nums[j];
                    if(sum == target){
                        ret.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }else if(sum < target) lo++;
                    else hi--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println("The solution set is " + fourSum(nums1, 0));

        int[] nums2 = {-1, 0, 1, 2, -1, -4};
        System.out.println("The solution set is " + fourSum(nums2, -1));
    }
}
