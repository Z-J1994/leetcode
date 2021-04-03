package easy;

/**
 * @author zhangjun
 * @version 2020/09/20  19:24
 */
public class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i = 0;i < startTime.length;i++){
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
