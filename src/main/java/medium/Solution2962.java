package medium;

/**
 * @author zhangjun
 * @since 2024/3/29 13:36
 */
public class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = getMaxElement(nums);
        int i = getKIndex(nums,max,1);
        int j = getKIndex(nums,max,k);
        if(j < 0){
            return 0L;
        }
        long count = i + 1;
        while(++j < nums.length){
            count += i + 1;
            if(nums[j] == max){
                while(nums[++i] != max){
                    count++;
                }
                count++;
            }
        }
        return count;
    }

    private int getMaxElement(int [] nums){
        int max = 0;
        for(int i : nums){
            if(max < i){
                max = i;
            }
        }
        return max;
    }

    private int getKIndex(int [] nums,int max,int k){
        for(int i = 0,c = 0;i < nums.length;i++){
            if(nums[i] == max){
                if(++c == k){
                    return i;
                }
            }
        }
        return -1;
    }
}
