package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;



public class RecoverTree {
    // Space Complexity: O(logN)
    static TreeNode pre = null;
    static TreeNode first = null;
    static TreeNode second = null;
    public static void recoverTree_1(TreeNode root){
        if(root == null) return;
        inOrderRecursive(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void inOrderRecursive(TreeNode root){
        if(root == null) return;
        inOrderRecursive(root.left);
        if(pre != null && pre.val > root.val){
            if(first == null){
                first = pre;
                second = root;
            }else {
                second = root;
            }
        }

        pre =root;

        inOrderRecursive(root.right);
    }

    // Space Complexity: O(1)

    public static void recoverTree_2(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null){
            if(cur.left == null){
                helper(prev, cur);
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode node = cur.left;

                while (node.right != null && node.right != cur)
                    node = node.right;

                if(node.right == null){
                    node.right = cur;
                    cur = cur.left;
                }else {
                    helper(prev, cur);
                    node.right = null;
                    prev = cur;
                    cur = cur.right;
                }
            }
        }


        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void helper(TreeNode prev, TreeNode cur){
        if(prev != null && prev.val > cur.val){
            if(first == null){
                first = prev;
            }
                second = cur;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.printInOrder(root);
        System.out.println();
//        recoverTree_1(root);
        recoverTree_2(root);
        root.printInOrder(root);
    }
}
