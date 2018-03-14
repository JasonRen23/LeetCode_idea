package LeetCode_idea.Sort;

import LeetCode_idea.dataStructure.ListNode;

public class SortList {
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode preMiddle = findMiddle(head);
        ListNode middle = preMiddle.next;
        preMiddle.next = null;

        ListNode head1 = sortList(head);
        ListNode head2 = sortList(middle);
        ListNode newHead = mergeTwoLists(head1, head2);

        return newHead;
    }

    public static ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = slow;

        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1 != null){
            p.next = l1;
        }

        if(l2 != null){
            p.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);

//        System.out.println(findMiddle(head).val);

        ListNode newHead = sortList(head);
        newHead.printList(newHead);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(3);

        ListNode newHead1 = sortList(head2);
        newHead1.printList(newHead1);
    }
}
