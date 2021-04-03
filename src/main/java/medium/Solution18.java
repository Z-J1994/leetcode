package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/05  20:51
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        for(int i = 0;i < length - 3;i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1;j < length - 2;j++){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if(nums[i] + nums[j] + nums[j] + nums[j + 1] > target){
                    break;
                }
                if(nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target){
                    continue;
                }
                for(int k = j + 1;k < length - 1;k++){
                    if(k != j + 1 && nums[k] == nums[k - 1]){
                        continue;
                    }
                    int key =  target - (nums[i] + nums[j] + nums[k]);
                    int index = binarySearch(nums,k + 1,key);
                    if(index != -1){
                        list.add(Arrays.asList(nums[i],nums[j],nums[k],key));
                        break;
                    }
                }
            }
        }
        return list;
    }

    private int binarySearch(int[] nums,int lo,int key){
        int hi = nums.length - 1;
        int mid;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < key){
                lo = mid + 1;
            }else if(nums[mid] > key){
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
