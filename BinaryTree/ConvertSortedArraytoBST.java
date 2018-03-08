package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

public class ConvertSortedArraytoBST {
    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int begin, int end){
        if(begin > end) return null;
        int rootIndex = begin + (end - begin) / 2;

        TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = helper(nums, begin, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        root.printPreOrder(root);
    }
}
