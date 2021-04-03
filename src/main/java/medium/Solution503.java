package medium;

/**
 * @author zhangjun
 * @date 2021/3/6
 */
public class Solution503 {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        if(length < 1){
            return nums;
        }
        int [] stack = new int[length];
        int top = -1;
        int max = nums[0];
        int maxIndex = 0;
        for(int i = 1;i < length;i++){
            int t = nums[i];
            if(t > max){
                max = t;
                maxIndex = i;
            }
        }
        nums[maxIndex] = -1;
        stack[++top] = max;

        int start = maxIndex == 0 ? length : maxIndex;

        for(int i = start - 1;i != maxIndex;i--){
            int t = nums[i];
            if(t == max){
                nums[i] = -1;
                top = 0;
                stack[top] = max;
            }else{
                while(t >= stack[top]){
                    top--;
                }
                nums[i] = stack[top];
                stack[++top] = t;
            }
            if(i == 0){
                i = length;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
