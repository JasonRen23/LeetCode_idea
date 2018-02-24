package LeetCode_idea.Stack;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights){
        if(heights.length < 1) return 0;
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();




        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
