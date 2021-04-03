package easy;

/**
 * @author zhangjun
 * @version 2020/09/24  23:50
 */
public class Solution1051 {
    public int heightChecker(int[] heights) {
        int [] bitmap = new int[101];
        int count = 0;
        for(int i = 0;i < heights.length;i++){
            bitmap[heights[i]]++;
        }
        for(int i = 0,j = 0;i < bitmap.length;i++){
            while(bitmap[i]-- > 0){
                if(heights[j++] != i){
                    count++;
                }
            }
        }
        return count;
    }
}
