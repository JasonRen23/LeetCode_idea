package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode buildTree(int[] preorder, int begin1, int end1,
                                     int[] inorder, int begin2, int end2, Map<Integer, Integer> map){
        if(begin1 > end1) return null;

        TreeNode root = new TreeNode(preorder[begin1]);

        int inRootPos = map.get(preorder[begin1]);
        int leftSize = inRootPos - begin2;

        root.left = buildTree(preorder, begin1 + 1, begin1 + leftSize,
                inorder, begin2, inRootPos - 1, map);
        root.right = buildTree(preorder, begin1 + leftSize + 1, end1,
                inorder, inRootPos + 1, end2, map);

        return root;
    }



    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        root.printPreOrder(root);
    }
}
