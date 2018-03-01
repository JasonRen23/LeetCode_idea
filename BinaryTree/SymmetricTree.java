package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.Stack;

public class SymmetricTree {
    public static boolean isSymmetric_1(TreeNode root){
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val){
            return helper(p.left, q.right) && helper(p.right, q.left);
        }
        return false;
    }



    public static boolean isSymmetric_2(TreeNode root){
        if(root == null) return true;

        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);

        while (!st.isEmpty()){
            TreeNode p = st.pop();
            TreeNode q = st.pop();

            if(p == null && q == null) continue;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;

            st.push(p.right);
            st.push(q.left);

            st.push(p.left);
            st.push(q.right);



        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(5);



        System.out.println(isSymmetric_1(root1));
        System.out.println(isSymmetric_1(root2));
        System.out.println(isSymmetric_1(root3));

        System.out.println();

        System.out.println(isSymmetric_2(root1));
        System.out.println(isSymmetric_2(root2));
        System.out.println(isSymmetric_2(root3));
    }
}
