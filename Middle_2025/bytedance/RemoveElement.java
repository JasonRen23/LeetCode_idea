package LeetCode_idea.Middle_2025.bytedance;

/**
 * 27. 移除元素
 * @author RenZhiCheng
 * @since 2025/2/3 23:23
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(re.removeElement(nums, val)); //2
    }
}
