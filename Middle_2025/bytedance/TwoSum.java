package LeetCode_idea.Middle_2025.bytedance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 力扣1 两数之和
 * @author RenZhiCheng
 * @since 2025/1/31 16:54
 */
public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
           if (hashTable.containsKey(target - nums[i])){
               return new int[]{hashTable.get(target - nums[i]), i};
           }
           hashTable.put(nums[i], i);
        }
        return new int[0];
    }



    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(arr1, target1))); // [0, 1]

        int[] arr2 = {3, 2, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(arr2, target2))); // [1, 2]

        int[] arr3 = {3, 3};
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(arr3, target3))); // [0, 1]
    }
}
