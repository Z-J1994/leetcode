package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  17:41
 */
public class Solution944 {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for(int index = 0;index < A[0].length();index++){
            char c = 'a';
            for(int i = 1;i < A.length;i++){
                if(A[i].charAt(index) < A[i - 1].charAt(index)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
