package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode slow2 = head;
                while(slow != slow2){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }

        return null;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println("The cycle begins from " + detectCycle(head).val);
    }
}
