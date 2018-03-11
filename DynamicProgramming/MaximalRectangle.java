package LeetCode_idea.DynamicProgramming;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(heights), maxArea);
        }

        return maxArea;

    }

    public static int maxRecFromBottom(int[] heights){
        if(heights == null || heights.length < 1) return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;


        for(int i = 0; i < heights.length; i++){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();

                int curArea = heights[j] * (i - k - 1);
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int i = heights.length;
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = heights[j] * (i - k - 1);
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println("The result is " + maximalRectangle(matrix));

    }
}
