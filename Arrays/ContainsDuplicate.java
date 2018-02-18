package LeetCode_idea.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate_1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num))
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate_2(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6};
        System.out.println(containsDuplicate_1(nums1));
        System.out.println(containsDuplicate_2(nums1));

        int[] nums2 = {1,2,3,4,2,6};
        System.out.println(containsDuplicate_1(nums2));
        System.out.println(containsDuplicate_2(nums2));
    }
}
