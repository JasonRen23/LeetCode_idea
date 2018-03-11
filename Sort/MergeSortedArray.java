package LeetCode_idea.Sort;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums2 == null) return;

        int last = m + n - 1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0){
            if(nums1[first] > nums2[second]){
                nums1[last] = nums1[first];
                first--;
            }else {
                nums1[last] = nums2[second];
                second--;
            }
            last--;
        }

        if(first < 0){
            for(int i = 0; i <= last; i++){
                nums1[i] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 6, 9, 0, 0, 0, 0};
        int[] nums2= {2, 4, 7, 8};
//        System.out.println(Arrays.toString(Arrays.copyOf(nums1, 4)));
        merge(nums1, 4, nums2, 4);

        System.out.println(Arrays.toString(nums1));

        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {};
        merge(nums3, 5, nums4, 0);
        System.out.println(Arrays.toString(nums3));

    }
}
