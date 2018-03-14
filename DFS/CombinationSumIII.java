package LeetCode_idea.DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> ret = new ArrayList<>();
        if(k == 0) return ret;
        List<Integer> path = new ArrayList<>();
        dfs(ret, path, n, k);
        return ret;
    }

    public static void dfs(List<List<Integer>> ret, List<Integer> path, int gap, int num){
        if(num == 0){
            if(gap == 0){
                ret.add(new ArrayList<>(path));
            }
            return;
        }

        if(gap < 1) return;

        final int start = path.isEmpty() ? 1 : path.get(path.size() - 1) + 1;
        for(int i = start; i < 10; i++){
            path.add(i);
            dfs(ret, path, gap - i, num - 1);
            path.remove(path.size() - 1);
        }



    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
