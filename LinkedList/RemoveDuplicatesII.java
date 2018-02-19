package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class RemoveDuplicatesII {
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int val = head.next.val;
                while(head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next = new ListNode(5);

        ListNode newHead1= deleteDuplicates(head1);
        newHead1.printList(newHead1);
    }
}
