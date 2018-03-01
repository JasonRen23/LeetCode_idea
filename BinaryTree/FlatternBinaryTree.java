package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.Stack;

public class FlatternBinaryTree {
    public static void flatten_1(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode dummy = root;
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            if(node != root) {
                dummy.right = node;
                dummy.left = null;
                dummy = dummy.right;
            }
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
    }


    public static void flatten_2(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return;

        flatten_2(root.left);
        flatten_2(root.right);

        if(root.left == null) return;

        TreeNode p = root.left;

        while (p.right != null) p = p.right;

        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        root.printPreOrder(root);
        flatten_1(root);
        System.out.println();
        root.printPreOrder(root);


    }
}
