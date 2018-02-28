package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    // 使用栈，时间复杂度O(n)，空间复杂度O(n)
    public static List<Integer> inorderTraversal_1(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null){
            if(root != null){
                st.push(root);
                root = root.left;
            }else {
                root = st.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
    // Morris中序遍历，时间复杂度O(n)，空间复杂度O(1)
    public static List<Integer> inorderTraversal_2(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

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
                    ret.add(cur1.val);
                    cur2.right = null;
                }
            }else {
                ret.add(cur1.val);
            }
            cur1= cur1.right;
        }
        return ret;
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
        System.out.println(inorderTraversal_1(root));
        System.out.println(inorderTraversal_2(root));
    }
}
