package LeetCode_idea.Middle_2025.bytedance;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * @author RenZhiCheng
 * @since 2025/1/31 14:10
 */
public class MergeTwoArray {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int m = 3;
        int[] arr2 = {2,5,6};
        int n = 3;
        merge1(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1)); //5

        int[] arr3 = {1,2,3,0,0,0};
        int m1 = 3;
        int[] arr4 = {2,5,6};
        int n1 = 3;
        merge2(arr3, m1, arr4, n1);
        System.out.println(Arrays.toString(arr3)); //5
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // 如果数组2为空，则直接返回数组1
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int p = 0, q = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p < m || q < n) {
            if (p == m) {
                cur = nums2[q++];
            } else if (q == n) {
                cur = nums1[p++];
            } else if (nums1[p] < nums2[q]) {
                cur = nums1[p++];
            } else {
                cur = nums2[q++];
            }
            sorted[p + q - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }
}
