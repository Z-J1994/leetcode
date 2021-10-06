package easy;

/**
 * @author zhangjun
 * @version 2021/10/6
 */
public class Solution414 {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        int a = nums[0];
        int b = a;
        int index = 1;
        while(b == a && index < length){
            b = nums[index++];
        }

        if(a < b){
            int t = a;
            a = b;
            b = t;
        }else if(a == b){
            return a;
        }

        boolean marked = false;
        int c = 0x80000000;
        for(int i = index;i < length;i++){
            if(nums[i] >= a){
                if(nums[i] == a){
                    continue;
                }
                c = b;
                b = a;
                a = nums[i];
                marked = true;
            }else if(nums[i] >= b){
                if(nums[i] == b){
                    continue;
                }
                c = b;
                b = nums[i];
                marked = true;
            }else if(nums[i] >= c){
                c = nums[i];
                marked = true;
            }
        }
        return (marked) ? c : a;
    }
}
