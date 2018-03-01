package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.Stack;


public class SameTree {
    public static boolean isSameTree_1(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
    }

    public static boolean isSameTree_2(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()){
            TreeNode nodep = pStack.pop();
            TreeNode nodeq = qStack.pop();

            if(nodep.val != nodeq.val)
                return false;
            if(nodep.left != null)
                pStack.push(nodep.left);
            if(nodeq.left != null)
                qStack.push(nodeq.left);
            if(pStack.size() != qStack.size())
                return false;

            if(nodep.right != null)
                pStack.push(nodep.right);
            if(nodeq.right != null)
                qStack.push(nodeq.right);
            if(pStack.size() != qStack.size())
                return false;
        }

        return true;
    }




    public static void main(String[] args) {
//         1         1
//        / \       / \
//       2   3     2   3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(isSameTree_1(root1, root2));
        System.out.println(isSameTree_2(root1, root2));

//        1          1
//        /           \
//       2             2

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);

        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);

        System.out.println(isSameTree_1(root4, root5));
        System.out.println(isSameTree_2(root4, root5));
    }
}
