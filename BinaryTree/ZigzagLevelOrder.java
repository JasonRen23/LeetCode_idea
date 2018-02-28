package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder_1(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        zigzagRecursive(root, ret, 1, true);
        return ret;
    }

    public static void zigzagRecursive(TreeNode root, List<List<Integer>> ret, int level, boolean flag){
        if(root == null) return;
        if(level > ret.size()){
            ret.add(new ArrayList<>());
        }

        if(flag){
            ret.get(level - 1).add(root.val);
        } else {
            ret.get(level - 1).add(0, root.val);
        }

        zigzagRecursive(root.left, ret, level + 1, !flag);
        zigzagRecursive(root.right, ret, level + 1, !flag);

    }

    public static List<List<Integer>> zigzagLevelOrder_2(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(flag){
                    level.add(node.val);
                }else {
                    level.add(0, node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            ret.add(level);
            flag = !flag;
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        System.out.println(zigzagLevelOrder_1(root));
        System.out.println(zigzagLevelOrder_2(root));

    }
}
