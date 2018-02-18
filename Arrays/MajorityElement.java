package LeetCode_idea.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        if(nums.length < 3) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement_2(int[] nums){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Map.Entry<Integer, Integer> majoriyEntry = null;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(majoriyEntry == null || majoriyEntry.getValue() < entry.getValue()){
                majoriyEntry = entry;
            }
        }
        return majoriyEntry.getKey();
    }

    public static int majorityElement_3(int[] nums){
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int countInRange(int[] nums, int num, int lo, int hi){
        int count = 0;
        for(int i = lo; i <= hi; ++i){
            if(nums[i] == num)
                count++;
        }
        return count;
    }

    private static int majorityElementRec(int[] nums, int lo, int hi){
        if(lo == hi)
            return nums[lo];

        int mid = lo + (hi - lo) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if(left == right)
            return left;

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElement_4(int[] nums){
        int count = 0;
        int candidate = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }





    public static void main(String[] args) {
        int[] nums1 = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        System.out.println("The majorityElement is " + majorityElement(nums1));
        System.out.println("The majorityElement is " + majorityElement_2(nums1));
        System.out.println("The majorityElement is " + majorityElement_3(nums1));
        System.out.println("The majorityElement is " + majorityElement_4(nums1));

        int[] nums2 = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println("The majorityElement is " + majorityElement(nums2));
        System.out.println("The majorityElement is " + majorityElement_2(nums2));
        System.out.println("The majorityElement is " + majorityElement_3(nums2));
        System.out.println("The majorityElement is " + majorityElement_4(nums2));
    }
}
