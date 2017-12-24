package LeetCode_idea.Arrays;

import java.util.HashMap;
import java.util.Map;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],i);
       }

        if(map.containsKey(val)==false)
           return nums.length;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println("length = " + removeElement(nums, val));
    }
}
