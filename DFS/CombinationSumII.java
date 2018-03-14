package LeetCode_idea.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        if(candidates == null) return ret;
        List<Integer> path = new ArrayList<>();
        dfs(candidates, ret, path, target, 0);
        return ret;
    }

    public static void dfs(int[] nums, List<List<Integer>> ret, List<Integer> path, int gap, int start){
        if(gap == 0){
            ret.add(new ArrayList<>(path));
            return;
        }

        int previous = -1;
        for(int i = start; i < nums.length; i++){
            if(gap < nums[i]) return;

            if(previous == nums[i]) continue;
            previous = nums[i];

            path.add(nums[i]);
            dfs(nums, ret, path, gap - nums[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(nums, 8));
    }
}
