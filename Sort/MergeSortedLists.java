package LeetCode_idea.Sort;

import LeetCode_idea.dataStructure.ListNode;

public class MergeSortedLists {
    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2){
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


    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeTwoLists_2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists_2(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

//        ListNode newHead = mergeTwoLists_1(l1, l2);
        ListNode newHead_1 = mergeTwoLists_2(l1, l2);
//        newHead.printList(newHead);
        newHead_1.printList(newHead_1);

        ListNode l3 = new ListNode(-9);
        l3.next = new ListNode(3);

        ListNode l4 = new ListNode(5);
        l4.next = new ListNode(7);

        ListNode newHead1 = mergeTwoLists_1(l3, l4);
        newHead1.printList(newHead1);
    }
}
