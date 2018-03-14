package LeetCode_idea.Sort;

import LeetCode_idea.dataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length < 1)
            return null;
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for(ListNode node : lists){
            if(node != null) heap.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (heap.size() > 0){
            ListNode node = heap.poll();
            head.next = node;
            if(node.next != null)
                heap.add(node.next);
            head = head.next;
        }

        return dummy.next;
    }

    public static Comparator<ListNode> comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode[] lists = new ListNode[2];
        lists[0] = l1;
        lists[1] = l2;

        ListNode newHead = mergeKLists(lists);
        newHead.printList(newHead);
    }

}
