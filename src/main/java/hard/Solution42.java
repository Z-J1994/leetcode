package hard;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2024/4/12 13:22
 */
public class Solution42 {

    public int trap(int[] height) {
        int total = 0,maxIndex = 0;
        for(int fast = 1,slow = 0,v = height[slow];fast < height.length;fast++){
            if(height[fast] >= v){
                while(++slow < fast){
                    total += v - height[slow];
                }
                v = height[fast];
            }
            if(height[fast] > height[maxIndex]){
                maxIndex = fast;
            }
        }

        for(int fast = height.length - 2,slow = height.length - 1,v = height[slow];fast >= maxIndex;fast--){
            if(height[fast] > v){
                while(--slow > fast){
                    total += v - height[slow];
                }
                v = height[fast];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
        System.out.println(s.trap(Parser.StringToIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")) == 6);
        System.out.println(s.trap(Parser.StringToIntArray("[2,0,2]")) == 2);
    }
}
