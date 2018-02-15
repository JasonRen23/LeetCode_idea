package LeetCode_idea.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        if(nums.length<2)return nums.length;
        int index=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[index-1])
                nums[index++]=nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println("The new length is " + removeDuplicates(nums));
    }
}
