package LeetCode_idea.Sort;

import java.util.Arrays;

public class SortColors {
    public static void sortColors_1(int[] nums){
        int red = 0, blue = nums.length - 1;

        for(int i = 0; i < blue + 1;){
            if(nums[i] == 0){
                swap(nums, i++, red++);
            }
            else if (nums[i] == 2){
                swap(nums, i, blue--);
            }
            else i++;
        }

    }

    public static void sortColors_2(int[] nums){
        int red = -1;
        int white = -1;
        int blue = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[++blue] = 2;
                nums[++white] = 1;
                nums[++red] = 0;
            }else if(nums[i] == 1){
                nums[++blue] = 2;
                nums[++white] = 1;
            }else {
                nums[++blue] = 2;
            }
        }
    }

    public static void sortColors_3(int[] nums){
        partition(nums, partition(nums, 0, nums.length, 0), nums.length, 1);
    }

    public static int partition(int[] nums, int begin, int end, int target){
        int pos = begin;

        for(;begin != end; ++begin){
            if(target == nums[begin])
                swap(nums, begin, pos++);
        }

        return pos;
    }






    public static void swap(int[] A, int i, int j){
        if(i != j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,0,1,2};
//        sortColors_1(nums);
//        sortColors_2(nums);
        sortColors_3(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {2,1,0,2,1,0};
//        sortColors_1(nums2);
//        sortColors_2(nums2);
        sortColors_3(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1,2};
        sortColors_3(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
