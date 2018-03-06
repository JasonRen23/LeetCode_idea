package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public static List<TreeNode> generateTrees(int n){
        if(n < 1) return new ArrayList<>();
       return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int begin ,int end){
        List<TreeNode> subTree = new ArrayList<>();
        if(begin > end){
            subTree.add(null);
        }
        else if(begin == end){
            subTree.add(new TreeNode(begin));
        }
        else{
            for(int k = begin; k <= end; k++){
                List<TreeNode> leftSubs = generateTrees(begin, k - 1);
                List<TreeNode> rightSubs = generateTrees(k + 1, end);
                for(TreeNode i : leftSubs){
                    for(TreeNode j : rightSubs){
                        TreeNode node = new TreeNode(k);
                        node.left = i;
                        node.right = j;
                        subTree.add(node);
                    }
                }
            }
        }


        return subTree;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
        System.out.println(generateTrees(0));

    }
}
