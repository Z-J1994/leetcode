package medium;

import java.util.Arrays;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/28 13:43
 */
public class Solution377 {
//    public int combinationSum4(int[] nums, int target) {
//        int n = nums.length;
//        int [] map = new int[target + 1];
//        map[0] = 1;
//        for(int i = 0;i <= target;i++){
//            int t = map[i];
//            boolean mark = false;
//            for(int j = 0;j < n;j++){
//                int index = i + nums[j];
//                if(index <= target){
//                    mark = true;
//                    map[i + nums[j]] += t;
//                }
//            }
//            if(!mark){
//                break;
//            }
//        }
//        return map[target];
//    }

    int[] map;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        map = new int[target + 1];
        Arrays.fill(map, -1);
        return dfs(nums, target);
    }

    public int dfs(int[] nums, int target) {
        int count = 0;
        for (int i = 0, l = nums.length; i < l; i++) {
            if (target < nums[i]) {
                return count;
            } else if (target == nums[i]) {
                return count + 1;
            } else {
                int t = map[target - nums[i]];
                if (t == -1) {
                    t = dfs(nums, target - nums[i]);
                    map[target - nums[i]] = t;
                }
                count += t;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        System.out.println(solution377.combinationSum4(new int[]{1, 2, 3}, 4)); //7

        System.out.println(solution377.combinationSum4(new int[]{2, 1, 3}, 35));//1132436852
    }
}
