package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    static List<List<Integer>> retList = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        if(root == null)return retList;
        List<Integer> path = new ArrayList<>();

        findPath(root, sum, 0, path);

        return retList;
    }

    public static void findPath(TreeNode root, int target, int current, List<Integer> path){
        if(root == null) return;

        current += root.val;
        path.add(root.val);

        boolean isLeaf = (root.left == null && root.right == null);

        if(current == target && isLeaf){
            retList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }


            findPath(root.left, target, current, path);

            findPath(root.right, target, current, path);


        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//
//        System.out.println(pathSum(root, 22));

        TreeNode root1 = new TreeNode(-2);
        root1.right = new TreeNode(-3);

        System.out.println(pathSum(root1, -5));
    }
}
