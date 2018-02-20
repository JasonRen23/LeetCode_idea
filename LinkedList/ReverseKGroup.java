package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;

        ListNode nextHead = head;
        for(int i = 0; i < k; ++i){
            if(nextHead != null)
                nextHead = nextHead.next;
            else
                return head; // if that is not enough to reverse, return head
        }

        ListNode cur = reverseKGroup(nextHead, k);

        while(k-- > 0){
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }

        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseKGroup(head, 2);
        newHead.printList(newHead);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode newHead2 = reverseKGroup(head2, 3);
        newHead.printList(newHead2);
     }
}
