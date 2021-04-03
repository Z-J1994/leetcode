package hard;

/**
 * @author zhangjun
 * @date 2021/4/2
 */
public class Interview17_21{
    public int trap(int[] height) {
        int result = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int left = 0;
        int leftMax = 0;
        while(right > left){
            rightMax = (height[right] > rightMax) ? height[right] : rightMax;
            leftMax = (height[left] > leftMax) ? height[left] : leftMax;
            if(height[left] > height[right]){
                result += rightMax - height[right];
                --right;
            }else{
                result += leftMax - height[left];
                ++left;
            }
        }
        return result;
    }
}
