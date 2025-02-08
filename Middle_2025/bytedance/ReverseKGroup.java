package LeetCode_idea.Middle_2025.bytedance;

import LeetCode_idea.dataStructure.ListNode;

/**
 * 25. K 个一组翻转链表
 * @author RenZhiCheng
 * @since 2025/2/3 23:21
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        ListNode end = hair;
        while (end.next != null) {
            for (int i = 0; i < k; ++i) {
                end = end.next;
                if (null == end) {
                    return hair.next;
                }
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseSubGroup(start);
            start.next = next;
            pre = start;
            end = pre;

        }

        return hair.next;
    }

    public static ListNode reverseSubGroup(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseKGroup(l1, 2);
        newHead.printList(newHead); // [2,1,4,3,5]
    }
}
