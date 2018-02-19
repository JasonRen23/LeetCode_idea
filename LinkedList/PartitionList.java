package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class PartitionList {
    public static ListNode partition(ListNode head, int x){
        if(head == null || head.next == null) return head;
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);

        ListNode smallHead = small;
        ListNode bigHead = big;

        ListNode p = head;
        while(p != null){
            if(p.val < x){
                small.next = p;
                small = small.next;
            }else{
                big.next = p;
                big = big.next;
            }
            p = p.next;
        }
        small.next = bigHead.next;
        big.next = null;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        ListNode newHead = partition(head, x);
        newHead.printList(newHead);
    }
}
