package LeetCode_idea.BinaryTree;

public class UniqueBinarySearchTree {
    public static int numTrees(int n){
       int[] f = new int[n + 1];

        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <=n; ++i){
            for(int k = 1; k <= i; k++){
                f[i] += f[k - 1] *f[i - k];
            }

        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3)); //5
    }
}
