package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root){
        if(root == null || (root.right == null && root.left == null)) return true;
         return height(root) != -1;
    }

    public static int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        if(left == -1)
            return -1;
        int right = height(node.right);
        if(right == -1)
            return -1;
        if(Math.abs(left - right) > 1)
            return -1;
        return left > right ?  left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        TreeNode root2= new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
    }
}
