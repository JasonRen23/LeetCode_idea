package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;



public class MinimumDepthofBinaryTree {

    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        return minDepth(root, false);
    }

   private static int minDepth(TreeNode root, boolean hasbrother){
        if(root == null) return hasbrother ? Integer.MAX_VALUE : 0;

        return  1 + Math.min(minDepth(root.left, root.right != null),
                minDepth(root.right, root.left != null));
   }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        System.out.println(minDepth(root));
    }
}
