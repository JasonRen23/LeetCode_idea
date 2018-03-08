package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;


import java.util.Stack;

public class KthSmallestElementinBST {
    public static int kthSmallest(TreeNode root, int k){
        if(root == null) return -1;
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null){
            if(root != null){
                st.push(root);
                root = root.left;
            }else {
                root = st.pop();
                k--;
                if(k == 0)
                    return root.val;
                root = root.right;
            }

        }

        return -1;
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

        System.out.println(kthSmallest(root, 4));
    }
}
