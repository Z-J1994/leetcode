package easy;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2022/5/24 13:08
 */
public class Solution1037 {
    public boolean isBoomerang(int[][] points) {
        for(int i = 0;i <= 3;i++){
            if(points[i % 3][0] == points[(i + 1) % 3][0] && points[i % 3][1] == points[(i + 1) % 3][1]){
                return false;
            }
        }
        if(points[0][0] == points[1][0] ^ points[0][0] == points[2][0]){
            return true;
        }
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]);
    }

    public static void main(String[] args) {
        Solution1037 s  = new Solution1037();
        System.out.println(s.isBoomerang(Parser.stringToIntMatrix("[[73,31],[73,19],[73,45]]", 2)));
    }
}