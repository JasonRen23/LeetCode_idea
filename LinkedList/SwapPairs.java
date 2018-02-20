package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = pre.next, next = cur.next;
        while(next != null){
            pre.next = next;
            cur.next = next.next;
            next.next = cur;

            pre = cur;
            cur = cur.next;
            next = cur == null ? null : cur.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairs_2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        head.next = swapPairs_2(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = swapPairs(head);
        newHead.printList(newHead);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        ListNode newHead2 = swapPairs_2(head2);
        newHead.printList(newHead2);
    }
}
