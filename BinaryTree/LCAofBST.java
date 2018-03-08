package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

public class LCAofBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while ((root.val - p.val) * (root.val - q.val) > 0){
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
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

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);


    }
}
