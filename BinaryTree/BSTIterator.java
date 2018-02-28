package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        while (root != null){
            st.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = st.pop();
        if(tmp.right != null){
            TreeNode p = tmp.right;
            while(p != null){
                st.push(p);
                p = p.left;
            }
        }
        return tmp.val;
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

        BSTIterator i = new BSTIterator(root);

        while (i.hasNext()) System.out.println(i.next());

    }
}
