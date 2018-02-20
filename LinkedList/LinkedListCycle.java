package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow ) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println("The list has cycle: " + hasCycle(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        System.out.println("The list has cycle: " + hasCycle(head1));


    }
}
