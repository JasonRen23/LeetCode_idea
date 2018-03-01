package LeetCode_idea.BinaryTree;



import java.util.LinkedList;
import java.util.Queue;




public class PopulatingNextRightPointersinEachNodeII {


    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Time: O(n) Space: O(n)
    public static void connect_1(TreeLinkNode root){
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode q = queue.peek();
            for(int i = 0; i < size; ++i){
                TreeLinkNode p;
                p = queue.poll();
                if(i != 0){
                    q.next = p;
                    q = q.next;
                }

                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);

            }
        }
    }

    // Time: O(n) Space: O(1)
    public static void connect_2(TreeLinkNode root){
        if(root == null) return;
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode p = dummy;
        while (root != null){
            if(root.left != null){
                p.next = root.left;
                p = p.next;
            }

            if(root.right != null){
                p.next = root.right;
                p = p.next;
            }

            root = root.next;

            if(root == null){
                p = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
    }

    public static void main(String[] args) {
//                 1
//                /  \
//               2    5
//              / \    \
//             3   4    6
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(5);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.right = new TreeLinkNode(6);

//        connect_1(root);
        connect_2(root);



    }
}
