package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/1/27
 */
public class Solution39 {
    private final List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0,target,new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int from, int target, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
        }
        for(int i = from;i < candidates.length;i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                dfs(candidates,i,target - candidates[i],list);
                list.remove(list.size() - 1);
            }
        }
    }
}
