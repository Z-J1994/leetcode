package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @version 2020/09/18  18:53
 */
public class Solution47 {

    List<List<Integer>> list = new ArrayList<>();
    int N;
    boolean [] marked;
    int [] temp;
    public List<List<Integer>> permuteUnique(int[] nums) {
        N = nums.length;
        marked = new boolean[N];
        temp = new int[N];
        Arrays.sort(nums);
        recursion(0,nums);
        return list;
    }

    public void recursion(int n,int [] nums){
        if(n < N){
            for(int i = 0;i < N;i++){
                if(marked[i] || i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]){
                    continue;
                }
                temp[n] = nums[i];
                marked[i] = true;
                recursion(n + 1,nums);
                marked[i] = false;
            }
        }else{
            list.add((ArrayList)Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }
    }

    public static void main(String[] args) {
        Solution47 p = new Solution47();
        int [] nums = {1,1,2};
        p.permuteUnique(nums);
        for(List<Integer> list : p.list){
            for(Integer i: list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
