package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class ReverseListII {
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if(m == n || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);//create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode prev = dummy;//make a pointer prev as a marker for the node before reversing
        for(int i = 0; i < m - 1; ++i)
            prev = prev.next;

        ListNode start = prev.next;// a pointer to the beginning of a sub-list that will be reversed
        ListNode cur = start.next;// a pointer to a node that will be reversed

        for(int i = m; i < n; ++i){
           start.next = cur.next;
           cur.next = prev.next;
           prev.next = cur;
           cur = start.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseBetween(head, 2, 4);
        newHead.printList(newHead);
    }
}
