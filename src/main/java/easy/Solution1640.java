package easy;

/**
 * @author zhangjun
 * @since 2022/9/22 12:52
 */
public class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int [] map = new int[101];
        for(int i = 0;i < arr.length;i++){
            map[arr[i]] = i;
        }
        for(int [] piece : pieces){
            int k = map[piece[0]];
            for(int j = 0;j < piece.length;j++,k++){
                if(k >= arr.length || arr[k] != piece[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
