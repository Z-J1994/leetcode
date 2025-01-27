package hard;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2024/4/12 13:22
 */
public class Solution42 {

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0, j = height.length - 1, k; i < j; ) {
            int iv = height[i], jv = height[j];
            if (iv < jv) {
                while ((k = height[++i]) <= iv) {
                    sum += iv - k;
                }
            } else if (iv > jv) {
                while ((k = height[--j]) <= jv) {
                    sum += jv - k;
                }
            } else {
                while (++i < j && (k = height[i]) <= iv) {
                    sum += iv - k;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
        System.out.println(s.trap(Parser.StringToIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")) == 6);
        System.out.println(s.trap(Parser.StringToIntArray("[2,0,2]")) == 2);
        System.out.println(s.trap(Parser.StringToIntArray("[2,1,0,1]")) == 1);
        System.out.println(s.trap(Parser.StringToIntArray("[0,1,0,2,1]")) == 1);
        System.out.println(s.trap(Parser.StringToIntArray("[4,2,0,3,2,5]")) == 9);
    }
}
