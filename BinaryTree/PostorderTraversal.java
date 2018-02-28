package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    // 使用单栈，时间复杂度O(n)，空间复杂度O(n)
    public static List<Integer> postOrderTraversal_1(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode tmp = null;

        while(!st.isEmpty()){
            tmp = st.peek();
            if(tmp.left != null && root != tmp.left && root != tmp.right){
                st.push(tmp.left);
            }else if(tmp.right != null && root != tmp.right){
                st.push(tmp.right);
            }else {
                ret.add(st.pop().val);
                root = tmp;
            }
        }
        return ret;
    }

    // 使用双栈，时间复杂度O(n)，空间复杂度O(n)
    public static List<Integer> postOrderTraversal_2(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);
        while (!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while (!st2.isEmpty()){
            ret.add(st2.pop().val);
        }

        return ret;
    }

    // Morris中序遍历，时间复杂度O(n)，空间复杂度O(1)
    public static List<Integer> postOrderTraversal_3(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                    printEdge(cur1.left, ret);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(root, ret);
        return ret;
    }

    public static void printEdge(TreeNode root, List<Integer> ret){
        TreeNode tail = reverseEdge(root);
        TreeNode cur = tail;
        while (cur != null){
            ret.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(root);
    }

    public static TreeNode reverseEdge(TreeNode from){
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
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
        System.out.println(postOrderTraversal_1(root));
        System.out.println(postOrderTraversal_2(root));
        System.out.println(postOrderTraversal_3(root));
    }
}
