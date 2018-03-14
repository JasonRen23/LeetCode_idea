package LeetCode_idea.Sort;

import java.util.Random;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k){
        if(nums == null || k > nums.length) return -1;
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi){
            int j = partition(nums, lo, hi);
            if(j > k){
                hi = j - 1;
            }else if (j < k){
                lo = j + 1;
            }else {
                break;
            }
        }

        return nums[k];

    }

    public static int partition(int[] nums, int begin, int end){
        int i = begin, j = end + 1;
        while (true){
            while (i < end && less(nums[++i], nums[begin]));
            while (j > begin && less(nums[begin],nums[--j]));
            if(i >= j)break;
            swap(nums, i, j);
        }
        swap(nums, begin, j);

        return j;
    }

    public static boolean less(Integer i, Integer j){
        return i.compareTo(j) < 0;
    }

    public static void swap(int[] A, int i, int j){
        if(i != j){
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }

    public static void shuffle(int[] nums){
        final Random rd = new Random();
        for(int i = 1; i < nums.length; i++){
            final int r = rd.nextInt(i);
            swap(nums, i, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
}
