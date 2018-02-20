package LeetCode_idea.LinkedList;

import java.util.HashMap;

public class LRUCache {
    private int count;
    private int capacity;
    private final HashMap<Integer, DListNode> map;
    private DListNode head, tail;

    static class DListNode{
        int key;
        int value;
        DListNode prev;
        DListNode next;

        private DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }

        private DListNode(){

        }
    }

    private void removeNode(DListNode node){
        DListNode next = node.next;
        DListNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void addToHead(DListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void moveToHead(DListNode node){
        removeNode(node);
        addToHead(node);
    }

    private DListNode popTail(){
        DListNode pre = tail.prev;
        removeNode(pre);
        return pre;
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DListNode();
        head.prev = null;
        tail = new DListNode();
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DListNode node = map.get(key);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value){
        DListNode node = map.get(key);
        if(node == null){
            DListNode cur = new DListNode(key, value);
            map.put(key, cur);
            addToHead(cur);
            count++;
            if(count > capacity){
                DListNode last = popTail();
                map.remove(last.key);
                count--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // return 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1
        cache.put(4, 4);                        // evicts key 1
        System.out.println(cache.get(1));       // returns -1
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
