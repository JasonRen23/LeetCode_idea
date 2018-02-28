package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static List<Integer> rightSideView_1(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = queue.poll();
                if(i == size - 1){
                    ret.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }

       return ret;

    }

    public static List<Integer> rightSideView_2(TreeNode root) {
        if(root == null) return  new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        levelRecursive(root, 0, ret);
        return ret;
    }

    public static void levelRecursive(TreeNode root, int level, List<Integer> ret){
        if(root == null) return;

        if(level == ret.size()){
            ret.add(root.val);
        }

        levelRecursive(root.right, level + 1, ret);
        levelRecursive(root.left, level + 1, ret);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView_1(root));
        System.out.println(rightSideView_2(root));

        System.out.println();

        //       8
        //    /    \
        //   6     10
        //  /
        // 5
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(6);
        root2.left.left = new TreeNode(5);
        root2.right = new TreeNode(10);

        System.out.println(rightSideView_1(root2)); // 8,10,5
        System.out.println(rightSideView_2(root2)); // 8,10,5
    }
}
