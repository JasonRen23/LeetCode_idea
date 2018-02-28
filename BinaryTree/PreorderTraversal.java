package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    // 使用栈，时间复杂度O(n)，空间复杂度O(n)
    public static List<Integer> preorderTraversal_1(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode tmp = st.pop();
            ret.add(tmp.val);
            if(tmp.right != null) st.push(tmp.right);
            if(tmp.left != null) st.push(tmp.left);
        }
        return ret;
    }
    // Morris先序遍历，时间复杂度O(n)，空间复杂度O(1)
    public static List<Integer> preorderTraversal_2(TreeNode root){
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
                    ret.add(cur1.val);
                    cur1 = cur1.left;
                    continue;
                }else {
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
        System.out.println(preorderTraversal_1(root));
        System.out.println(preorderTraversal_2(root));
    }
}
