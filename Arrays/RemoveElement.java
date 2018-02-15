package LeetCode_idea.Arrays;


public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }



    public static void main(String[] args) {
        int[] nums1 = {3,2,2,3};
        int val = 3;
        System.out.println("length = " + removeElement(nums1, val));

        int[] nums2= {3, 3};
        int val2 = 5;
        System.out.println("length = " + removeElement(nums2, val2));
    }
}
