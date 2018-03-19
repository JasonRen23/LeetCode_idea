package LeetCode_idea.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null) return ret;
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, ret, target, 0);
        return ret;
    }

    public static void dfs(int[] nums, List<Integer> path, List<List<Integer>> ret, int gap, int start){
        if(gap == 0){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(gap < nums[i]) return;

            path.add(nums[i]);
            dfs(nums, path, ret, gap-nums[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums, 7));
    }
}
