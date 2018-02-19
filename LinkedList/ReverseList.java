package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class ReverseList {
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newHead = reverseList(head);
        newHead.printList(newHead);

    }
}
