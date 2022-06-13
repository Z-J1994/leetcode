package easy;

/**
 * @author zhangjun
 * @version 2020/09/24  23:50
 */
public class Solution1051 {
    public int heightChecker(int[] heights) {
        int [] map = new int[101];
        for(int i : heights){
            map[i]++;
        }
        int count = 0;
        for(int i = 1,index = 0;i < 101;i++){
            for(int j = 0;j < map[i];j++,index++){
                if(i != heights[index]){
                    count++;
                }
            }
        }
        return count;
    }
}
