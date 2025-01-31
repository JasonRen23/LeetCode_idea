package LeetCode_idea.Middle_2025.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RenZhiCheng
 * @since 2025/1/31 17:12
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        while (next != null){
            list.add(next.val);
            next = next.next;
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return Arrays.toString(res);
    }
}
