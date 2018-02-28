package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        levelReverse(root, 1, ret);
        return ret;
    }

    public static void levelReverse(TreeNode root, int level, List<List<Integer>> ret){
        if(root == null) return;

        if(level > ret.size()){
            ret.add(new ArrayList<>());
        }
            ret.get(level - 1).add(root.val);
            levelReverse(root.left, level + 1, ret);
            levelReverse(root.right, level + 1, ret);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}
