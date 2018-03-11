package LeetCode_idea.Sort;

import LeetCode_idea.dataStructure.ListNode;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
//        dummy.next = head;

        ListNode cur = head;

        while (cur != null){
            ListNode pos = findInsertPos(dummy, cur.val);
            ListNode temp = cur.next;
            cur.next = pos.next;
            pos.next = cur;
            cur = temp;

        }

        return dummy.next;
    }

    static ListNode findInsertPos(ListNode head, int x){
        ListNode pre = null;
        for(ListNode cur = head; cur != null && cur.val <= x; pre = cur, cur= cur.next);
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);

        ListNode newHead = insertionSortList(head);
        newHead.printList(newHead);
    }
}
