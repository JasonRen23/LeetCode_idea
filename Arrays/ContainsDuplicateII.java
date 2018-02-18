package LeetCode_idea.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate_1(int[] nums, int k){
        if(nums == null || nums.length < 2) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; ++i){
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate_2(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,2,6};
        System.out.println(containsNearbyDuplicate_1(nums1, 2));
        System.out.println(containsNearbyDuplicate_1(nums1, 3));

        System.out.println(containsNearbyDuplicate_2(nums1, 2));
        System.out.println(containsNearbyDuplicate_2(nums1, 3));    }
}
