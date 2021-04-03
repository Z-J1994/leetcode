package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  16:48
 */
public class Solution682 {
    public int calPoints(String[] ops) {
        int [] nums = new int[ops.length];
        int top = -1;
        int sum = 0;
        for(int i = 0;i < ops.length;i++){
            String s = ops[i];
            if("+".equals(s)){
                int t = nums[top] + nums[top - 1];
                nums[++top] = t;
                sum += t;
            }else if("D".equals(s)){
                nums[++top] = nums[top - 1] * 2;
                sum += nums[top];
            }else if("C".equals(s)){
                sum -= nums[top--];

            }else{
                nums[++top] = Integer.parseInt(s);
                sum += nums[top];
            }
        }
        return sum;
    }
}
