package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode p = l1, q = l2;
        int carry = 0;
        while(p != null || q != null){
            final int x = (p == null) ? 0 : p.val;
            final int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;

        }
        if(carry > 0){
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode newHead = addTwoNumbers(l1, l2);
        newHead.printList(newHead);
    }
}
