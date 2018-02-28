package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder_1(TreeNode root){
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

    public static List<List<Integer>> levelOrder_2(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = root;
        TreeNode nLast = null;
        queue.offer(root);
        ret.add(new ArrayList<>());
        while (!queue.isEmpty()){
            root = queue.poll();
            ret.get(level - 1).add(root.val);
            if(root.left != null){
                queue.add(root.left);
                nLast = root.left;
            }
            if(root.right != null){
                queue.add(root.right);
                nLast = root.right;
            }
            if(root == last && !queue.isEmpty()){
                ret.add(new ArrayList<>());
                level++;
                last = nLast;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder_1(root));
        System.out.println(levelOrder_2(root));
    }
}
