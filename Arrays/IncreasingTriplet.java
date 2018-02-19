package LeetCode_idea.Arrays;

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3) return false;

        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

        for(int x = 0; x < nums.length; ++x){
            if(nums[x] <= small){
                small = nums[x];
            }else if(nums[x] <= big){
                big = nums[x];
            }else{
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};//true
        System.out.println(increasingTriplet(nums1));


        int[] nums2 = {1,4,3,2,1}; //false
        System.out.println(increasingTriplet(nums2));
    }
}
