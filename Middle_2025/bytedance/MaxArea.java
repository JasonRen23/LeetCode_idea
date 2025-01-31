package LeetCode_idea.Middle_2025.bytedance;

/**
 * 11. 盛最多水的容器
 * @author RenZhiCheng
 * @since 2025/2/1 01:43
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); //49
    }
}
