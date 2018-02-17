package LeetCode_idea.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    // 16ms user arraylist to store number
    public static String getPermutation(int n, int k){
        List<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int fact = 1;
        for(int i = 1; i <=n; ++i){
            fact *= i;
            num.add(i);
        }
        for(int i = 0, l = k - 1; i < n; ++i){
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    //98.75% used array to store the chose number
    public static String getPermutation_2(int n, int k){
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        int fact = 1;
        for(int i = 1; i <=n; ++i){
            fact *= i;
        }
        for(int i = 0, l = k - 1; i < n; ++i){
            fact /= (n - i);
            int index = (l / fact);
            sb.append(findKth(used, index));
            l -= index * fact;
        }
        return sb.toString();
    }

    public static int findKth(boolean[] used, int digit){
        int res = -1;
        while(digit >= 0){
            if(!used[++res])
                digit--;
        }
        used[res] = true;
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 14));
        System.out.println(getPermutation(3, 6));

        System.out.println(getPermutation_2(4, 14));
        System.out.println(getPermutation_2(3, 6));
    }
}
