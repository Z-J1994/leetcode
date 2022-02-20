package easy;

/**
 * @author zhangjun
 * @version 2022/2/18
 */
public class Solution1791 {
    public int findCenter(int[][] edges) {
        int [] a = edges[0];
        int [] b = edges[1];
        if(a[0] == b[0] || a[0] == b[1]){
            return a[0];
        }
        return a[1];
    }
}
