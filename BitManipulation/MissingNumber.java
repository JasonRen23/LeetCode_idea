package LeetCode_idea.BitManipulation;

public class MissingNumber {
    public static int missingNumber_1(int[] nums){
        if(nums == null || nums.length < 1) return -1;
        int result = 0;
        for(int i = 0 ; i < nums.length; i++){
            result ^= (i + 1) ^ nums[i];
        }
        return result;
    }

    public static int missingNumber_2(int[] nums){
        final int n = nums.length;
        int sum = 0;
        int target = (1 + n) * n / 2;
        for(int i = 0 ; i < n; i++){
           sum += nums[i];
        }

        return target - sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 0, 1};
        System.out.println(missingNumber_1(arr1));
        System.out.println(missingNumber_2(arr1));
        int[] arr2 = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber_1(arr2));
        System.out.println(missingNumber_2(arr2));
        int[] arr3 = {1,2,3};
        System.out.println(missingNumber_1(arr3));
        System.out.println(missingNumber_2(arr3));

    }
}
