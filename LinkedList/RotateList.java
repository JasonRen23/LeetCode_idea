package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode p = head;
        // get the length of list
        while(p.next != null){
            len++;
            p = p.next;
        }

        k = len - k % len;
        p.next = head; // make the last pointer point to head
        for(int i = 0; i < k; ++i){
            p = p.next;
        }
        head = p.next; // new head
        p.next = null; // disconnect the loop
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = rotateRight(head, 2);
        newHead.printList(newHead);
    }
}
