package LeetCode_idea.LinkedList;

public class CopyRandomList {
    static class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {this.label = x;}
    }
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head == null) return head;
        RandomListNode node = head;

        // copy the list but without random pointer
        while(node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        // copy random pointer
        node = head;
        while(node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }else{
                node.next.random = null;
            }
            node = node.next.next;
        }

        //disconnect the two list
        RandomListNode newHead = head.next;
        node = head;
        while(node != null){
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
            }
            node = node.next;
        }

        return newHead;
    }

    public static void printList(RandomListNode head){
        while(head != null){
            System.out.print(head.label + "->");
            head= head.next;
        }
        System.out.println("null");
    }

    public static boolean isSame(RandomListNode head1, RandomListNode head2){
        while(head1 !=null && head2 != null){
            if(head1 == head2){
                head1 = head1.next;
                head2 = head2.next;
            }else{
                return false;
            }
        }
        return head1 == null && head2 == null;
    }

    public static void main(String[] args) {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------

        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next;
        head.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;

        RandomListNode temp = head;
        printList(head);
        RandomListNode newHead = copyRandomList(head);
        printList(head);
        printList(newHead);
        System.out.println(isSame(temp, head));
        System.out.println(isSame(head, newHead));
        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        RandomListNode head2 = new RandomListNode(1);
        head2.next = new RandomListNode(2);
        head2.next.next = new RandomListNode(3);
        head2.next.next.next = new RandomListNode(4);
        head2.next.next.next.next = new RandomListNode(5);
        head2.next.random = head2.next.next.next.next;
        head2.next.next.next.random = head2.next;
        head.next.next.random = head.next.next;

        System.out.println();
        temp = head2;
        printList(head2);
        RandomListNode newHead2 = copyRandomList(head2);
        printList(head2);
        printList(newHead2);
        System.out.println(isSame(temp, head2));
        System.out.println(isSame(head2, newHead2));
    }
}
