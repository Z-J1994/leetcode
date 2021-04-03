package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @version 2020/09/20  9:38
 */
public class Solution78 {
//破烂解法
//    List<List<Integer>> list = new ArrayList<>();
//    int N;
//    int [] temp;
//    int length;
//    public List<List<Integer>> subsets(int[] nums) {
//        length = nums.length;
//        temp = new int[length];
//        for(int i = 0; i < length;i++){
//            N = i;
//            recursion(0,0,nums);
//        }
//        N = length;
//        recursion(0,0,nums);
//        return list;
//    }
//
//    public void recursion(int n,int index,int [] nums){
//        if(n < N){
//            for(int i = index;i < length;i++){
//                temp[n] = nums[i];
//                recursion(n + 1,i + 1,nums);
//            }
//        }else{
//            list.add((ArrayList)Arrays.stream(temp,0,N).boxed().collect(Collectors.toList()));
//        }
//    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList;
        int length = 0x1 << nums.length;
        for(int mask = 0;mask < length;mask++){
            subList = new ArrayList<>();
            for(int i = 0; i < nums.length;i++){
                if(((mask >>> i) & 0x1) != 0){
                    subList.add(nums[i]);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
