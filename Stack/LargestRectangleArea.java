package LeetCode_idea.Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea_1(int[] heights){
        if(heights.length < 1) return 0;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

       for(int i = 0; i < heights.length; ++i){
           while (!st.isEmpty() && heights[i] <= heights[st.peek()]){
                int j = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                int curArea = (i - k - 1) * heights[j];
                maxArea = Math.max(curArea, maxArea);
           }
           st.push(i);
       }

       while (!st.isEmpty()){
           int i = heights.length;
           int j = st.pop();
           int k = st.isEmpty() ? -1 : st.peek();
           int curArea = (i - k - 1) * heights[j];
           maxArea = Math.max(curArea, maxArea);
       }
       return maxArea;

    }


    public static int largestRectangleArea_2(int[] heights){
       if(heights.length < 1) return 0;
       int maxArea = 0;
       int[] heightsNew = Arrays.copyOf(heights, heights.length + 1);
       Stack<Integer> st = new Stack<>();

       for(int i = 0; i < heightsNew.length; ++i){
           while (!st.isEmpty() && heightsNew[i] <= heightsNew[st.peek()]){
               int j = st.pop();
               int k = st.isEmpty() ? -1 : st.peek();
               int curArea = (i - k - 1) * heightsNew[j];
               maxArea = Math.max(curArea, maxArea);
           }
           st.push(i);
       }
       return maxArea;

    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea_1(heights));
        System.out.println(largestRectangleArea_2(heights));
    }
}
