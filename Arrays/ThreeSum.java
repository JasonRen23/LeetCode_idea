package LeetCode_idea.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        if(nums == null || nums.length < 3) return null;
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            if(nums[i] * 3 > 0) break; // Too big
            if(nums[i] + 2 * nums[nums.length - 1] < 0) continue; // Too small
            if(i == 0 || nums[i] != nums[i - 1]){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        ret.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    }else if(nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("The solution set is " + threeSum(nums1));

        int[] nums2 = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println("The solution set is " + threeSum(nums2));
    }
}
