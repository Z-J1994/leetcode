package easy;

/**
 * @author zhangjun
 * @version 2020/09/28  17:41
 */
public class Solution944 {
    public int minDeletionSize(String[] A) {
        int count = 0;
        int length = A[0].length();
        for(int index = 0;index < length;index++){
            char p = A[0].charAt(index);
            char c;
            for(int i = 1;i < A.length;i++){
                if((c = A[i].charAt(index)) < p){
                    count++;
                    break;
                }
                p = c;
            }
        }
        return count;
    }
}
