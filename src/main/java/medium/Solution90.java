package medium;

import java.util.*;

/**
 * @author zhangjun
 * @date 2021/3/31
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    Map<List<Integer>,Integer> map = new HashMap<>();
    private void dfs(int [] nums,int index,ArrayList<Integer> list){
        if(index == nums.length){
            return;
        }
        if(map.putIfAbsent(list,1) == null){
            result.add(new ArrayList<>(list));
        }
        dfs(nums,index + 1,list);

        list.add(nums[index]);

        if(map.putIfAbsent(list,1) == null){
            result.add(new ArrayList<>(list));
        }
        dfs(nums,index + 1,list);
        list.remove(list.size() - 1);
    }
}
