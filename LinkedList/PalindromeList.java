package LeetCode_idea.LinkedList;

import LeetCode_idea.dataStructure.ListNode;

public class PalindromeList {
    // Time: O(n) Space: O(1)
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);

        ListNode cur = slow.next;
        ListNode pre = head;
        while(cur != null){
            if(cur.val != pre.val) return false;
            pre = pre.next;
            cur = cur.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // Time: O(n^2) Space: O(1)
    public static boolean isPalindrome_2(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode slow = head, cur = head.next;
        while(cur.next != null){
            if(slow.val == cur.next.val){
                if(cur.next.next != null) return false;
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if(cur == null || slow.val == cur.val)
                    return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(1);
        System.out.println("The list is palindrome : " + isPalindrome(head1));
        System.out.println("The list is palindrome : " + isPalindrome_2(head1));
        System.out.println("The list is palindrome : " + isPalindrome(head2));
        System.out.println("The list is palindrome : " + isPalindrome_2(head2));
        System.out.println("The list is palindrome : " + isPalindrome(head3));
        System.out.println("The list is palindrome : " + isPalindrome_2(head3));

    }
}
