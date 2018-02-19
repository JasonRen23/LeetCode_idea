package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode pre = head, cur = head.next;
        while(cur != null){
           if(pre.val == cur.val)
               pre.next = cur.next;
           else
               pre = cur;
           cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode newHead1 = deleteDuplicates(head1);
        newHead1.printList(newHead1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        ListNode newHead2 = deleteDuplicates(head2);
        newHead1.printList(newHead2);
    }
}
