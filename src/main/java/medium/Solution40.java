package medium;

import java.util.*;

public class Solution40 {
    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target,new ArrayList<>(),-1);
        return result;
    }

    private void dfs(int[] candidates, int from, int target, List<Integer> list,int p){
        if(from >= candidates.length || target <= 0){
            if(target == 0){
                List<Integer> l = new ArrayList<>(list);
                result.add(l);
            }
            return;
        }
        dfs(candidates,from + 1,target,list,candidates[from]);
        if(candidates[from] != p){
            list.add(candidates[from]);
            dfs(candidates,from + 1,target - candidates[from],list,-1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution40 s = new Solution40();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
