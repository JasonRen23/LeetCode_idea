package LeetCode_idea.Sort;

public class FindingMissingPositive {
    public static int firstMissingPositive(int[] nums){
        if(nums == null || nums.length < 1) return 1;
        final int n = nums.length;
        for(int i = 0; i < n; i++){
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    public static void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
        if(i!=j){
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,0};
        System.out.println(firstMissingPositive(arr1));
        int[] arr2 = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr2));
        int[] arr3 = {2};
        System.out.println(firstMissingPositive(arr3));

    }
}
