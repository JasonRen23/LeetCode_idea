package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static boolean isValidBST_1(TreeNode root){
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal){
        if(root == null) return true;

        return (minVal == null || root.val > minVal) && (maxVal == null || root.val < maxVal) &&
                isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static boolean isValidBST_2(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while (root != null || !st.isEmpty()){
            while (root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static boolean isValidBST_3(TreeNode root){
        if(root == null) return true;

        boolean res = true;
        TreeNode pre = null;
        TreeNode cur1 = root;
        TreeNode cur2 = null;

        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2= cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }

            if(pre != null && pre.val >= cur1.val){
                res = false;
            }

            pre =cur1;
            cur1= cur1.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(isValidBST_1(root1));//true
        System.out.println(isValidBST_2(root1));//true
        System.out.println(isValidBST_3(root1));//true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(isValidBST_1(root2));//false
        System.out.println(isValidBST_2(root2));//false
        System.out.println(isValidBST_3(root2));//false

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        System.out.println(isValidBST_1(root3)); //false
        System.out.println(isValidBST_2(root3)); //false
        System.out.println(isValidBST_3(root3)); //false

        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        root4.right = new TreeNode(15);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(20);

        System.out.println(isValidBST_1(root4));
        System.out.println(isValidBST_2(root4));

        System.out.println(Integer.MAX_VALUE);
    }
}
