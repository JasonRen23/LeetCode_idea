package LeetCode_idea.Middle_2025.bytedance;

import LeetCode_idea.dataStructure.ListNode;

/**
 * 23. 合并 K 个升序链表
 *
 * @author RenZhiCheng
 * @since 2025/2/3 23:18
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (null == a || null == b) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aa = a, bb = b;
        while (aa != null && bb != null) {
            if (aa.val < bb.val) {
                tail.next = aa;
                aa = aa.next;
            } else {
                tail.next = bb;
                bb = bb.next;
            }
            tail = tail.next;
        }
        tail.next = (aa != null) ? aa : bb;

        return head.next;
    }

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
