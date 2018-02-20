package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;

        while(--n >= 0){
            q = q.next;
        }
        while(q.next != null){
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = removeNthFromEnd(head, 2);
        newHead.printList(newHead);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode newHead2 = removeNthFromEnd(head2, 2);
        newHead2.printList(newHead2);
    }
}
