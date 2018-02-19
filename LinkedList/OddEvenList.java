package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class OddEvenList {
    public static ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = oddEvenList(head);
        newHead.printList(newHead);
    }
}
