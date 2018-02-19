package LeetCode_idea.dataStructure;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        val = x;
    }
//    public TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    public int getval() {
//        return val;
//    }
//
//    public void setval(int val) {
//        this.val = val;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(TreeNode left) {
//        this.left = left;
//    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public void setRight(TreeNode right) {
//        this.right = right;
//    }

    public static void printPreOrder(TreeNode root){
        /**
         * @description: preOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);

        }
    }

    public static void preOrderUnRecur(TreeNode root){
        System.out.println("pre-order: ");
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val + " ");
                if(root.right != null){
                    stack.push(root.right);
                }
                if(root.left != null){
                    stack.push(root.left);
                }
            }
        }
        System.out.println();
    }
    public static void printInOrder(TreeNode root){
        /**
         * @description: inOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);

        }
    }

    public static void inOrderUnRecur(TreeNode root){
        System.out.println("in-order: ");
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || root != null){
                 if(root != null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    root = root.right;
                }
            }
        }
        System.out.println();
    }

    public static void printPostOrder(TreeNode root){
        /**
         * @description: postOrder of the Tree(recursive method)
         * @param: [root] root of the Tree
         * @return: void
         */
        if(root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void posOrderUnRecur1(TreeNode root){
        System.out.println("pos-order: ");
        if(root != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if(root.left != null){
                    s1.push(root.left);
                }
                if(root.right != null){
                    s1.push(root.right);
                }

            }

            while (!s2.isEmpty()){
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(TreeNode root){
        System.out.println("pos-order: ");
        if(root != null){
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            TreeNode c = null;
            while (!s.isEmpty()){
                c = s.peek();
                if(c.left != null && root != c.left && root != c.right){
                    s.push(c.left);
                }
                else if(c.right != null && root != c.right){
                    s.push(c.right);
                }else {
                    System.out.print(s.pop().val + " ");
                    root = c;
                }

            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrderUnRecur(root);
        printPreOrder(root);

        System.out.println();
        inOrderUnRecur(root);
        printInOrder(root);

        System.out.println();
        posOrderUnRecur1(root);
        posOrderUnRecur2(root);
        printPostOrder(root);


    }

}  

