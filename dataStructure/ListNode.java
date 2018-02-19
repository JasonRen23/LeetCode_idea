package LeetCode_idea.dataStructure;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }
    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getValue() {
        return this.val;
    }

    public ListNode getNext() {
        return this.next;
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
