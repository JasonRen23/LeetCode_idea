package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import static LeetCode_idea.BinaryTree.PreorderTraversal.preorderTraversal_1;

public class InvertBinaryTree {
    public static TreeNode invertTree_1(TreeNode root){
        if(root == null) return null;

        invertRecursive(root);

        return root;
    }

    public static void invertRecursive(TreeNode root){

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left != null) invertRecursive(root.left);
        if(root.right != null)invertRecursive(root.right);
    }

    public static TreeNode invertTree_2(TreeNode root){
        if(root == null) return root;

        TreeNode left = invertTree_2(root.left);
        TreeNode right = invertTree_2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        invertTree_1(root);
        System.out.println(preorderTraversal_1(root));


        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(6);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(7);
        root2.right = new TreeNode(10);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(11);

        invertTree_2(root2);
        System.out.println(preorderTraversal_1(root2));



    }
}
