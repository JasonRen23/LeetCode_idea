package LeetCode_idea.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal_1(List<List<Integer>> triangle){
        final int n = triangle.size();
        int[] minPath = new int[n];

        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            minPath[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                minPath[j] = Math.min(minPath[j], minPath[j + 1]) + triangle.get(i).get(j);
            }
        }

        return minPath[0];
    }

    public static int minimumTotal_2(List<List<Integer>> triangle){
        if(triangle.size() == 0) return 0;

        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                List<Integer> nextRow = triangle.get(i + 1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[] level1 = new Integer[] {2};
        triangle.add(Arrays.asList(level1));

        Integer[] level2 = new Integer[] {3,4};
        triangle.add(Arrays.asList(level2));

        Integer[] level3 = new Integer[] {6, 5, 7};
        triangle.add(Arrays.asList(level3));

        Integer[] level4 = new Integer[] {4, 1, 8, 3};
        triangle.add(Arrays.asList(level4));

        System.out.println(triangle);

        System.out.println(minimumTotal_1(triangle));
        System.out.println(minimumTotal_2(triangle));
    }
}
