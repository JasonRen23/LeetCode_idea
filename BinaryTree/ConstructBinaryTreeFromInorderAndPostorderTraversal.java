package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);
    }


    public static TreeNode buildTree(int[] inorder, int begin1, int end1,
                                     int[] postorder, int begin2, int end2, Map<Integer, Integer> map){
        if(begin2 > end2) return null;

        TreeNode root = new TreeNode(postorder[end2]);
        int inRootPos = map.get(postorder[end2]);
        int leftSize = inRootPos - begin1;

        root.left = buildTree(inorder, begin1, inRootPos - 1,
                postorder, begin2, begin2 + leftSize - 1, map);
        root.right = buildTree(inorder, inRootPos + 1, end1,
                postorder, begin2 + leftSize,  end2 - 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        root.printPreOrder(root);
    }
}
