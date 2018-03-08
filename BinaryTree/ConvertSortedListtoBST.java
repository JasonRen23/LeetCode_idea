package LeetCode_idea.BinaryTree;

import LeetCode_idea.dataStructure.ListNode;
import LeetCode_idea.dataStructure.TreeNode;

public class ConvertSortedListtoBST {
    public static TreeNode sortedListToBST_1(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode mid = cutAtMiddle(head);
        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST_1(head);
        root.right = sortedListToBST_1(mid.next);

        return root;
    }
    public static ListNode cutAtMiddle(ListNode head){
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = slow;

        while (fast != null && fast.next != null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preSlow.next = null;
        return slow;

    }


    static class Container{
        ListNode p;
        public Container(ListNode p){
            this.p = p;
        }
    }


    public static TreeNode sortedListToBST_2(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }

        return sortedListToBST(new Container(head), 0,len - 1);

    }

    public static TreeNode sortedListToBST(Container list, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBST(list, start, mid - 1);
        TreeNode parent = new TreeNode(list.p.val);
        parent.left = leftChild;
        list.p = list.p.next;
        parent.right = sortedListToBST(list, mid + 1, end);

        return parent;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST_1(head);
        root.printPreOrder(root);

        System.out.println();

        ListNode head_1 = new ListNode(-10);
        head_1.next = new ListNode(-3);
        head_1.next.next = new ListNode(0);
        head_1.next.next.next = new ListNode(5);
        head_1.next.next.next.next = new ListNode(9);

        TreeNode root_1 = sortedListToBST_2(head_1);
        root_1.printPreOrder(root_1);

    }
}
