package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class ReorderList {
    public static void reorderList(ListNode head){
        if(head == null || head.next == null) return;

        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);

        //merge
        ListNode dummy = slow.next;
        slow.next = null;
        mergeTwoList(head, dummy);

    }

    public static void mergeTwoList(ListNode l1, ListNode l2){
        // l2 is shorter when the number of node is odd
        while(l2 != null){
            ListNode temp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = temp;
            l1 = temp;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList(head);
        head.printList(head);
    }
}
