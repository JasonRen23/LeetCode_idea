package LeetCode_idea.Arrays;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k){
        if(k == 0 || nums.length < 2) return;
        int len = nums.length;
        int pos = len - k%len;

        int[] arr = new int[len * 2];
        System.arraycopy(nums, 0, arr, 0, len);
        System.arraycopy(nums, 0, arr, len, len);

        System.arraycopy(arr, pos, nums, 0, len);

    }

    public static void rotate_2(int[] nums, int k){
        if(k == 0 || nums.length < 2) return;
        int len = nums.length;
        int pos = len - k % len;
        k = k%len;

        int[] arr = new int[k];
        for(int i = 0; i < k; ++i){
            arr[i] = nums[pos++];
        }

        for(int i = len - 1 - k; i>=0; --i){
            nums[i + k] = nums[i];
        }

        for(int i = 0; i < k; ++i){
            nums[i] = arr[i];
        }

    }

    public static void rotate_3(int[] nums, int k){
        if(k == 0 || nums.length < 2) return;
        int len = nums.length;
        k = k%len;
        int pos = len - k;

        reverse(nums, 0, pos - 1);
        reverse(nums, pos, len - 1);
        reverse(nums, 0, len - 1);
    }

    private static void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        int[] nums1= {1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2= {1, 2};
        rotate_2(nums2, 1);
        System.out.println(Arrays.toString(nums2));

        int[] nums3= {1, 2, 3, 4, 5, 6, 7};
        rotate_3(nums3, 3);
        System.out.println(Arrays.toString(nums3));

    }
}
