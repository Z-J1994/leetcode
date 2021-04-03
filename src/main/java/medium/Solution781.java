package medium;

/**
 * @author zhangjun
 * @version 2021/4/4
 */
public class Solution781 {
    public int numRabbits(int[] answers) {
        int [] map = new int[1000];
        int sum = 0;
        for(int t : answers){
            if(map[t] == 0) {
                map[t] = t;
                sum += t + 1;
            }else{
                --map[t];
            }
        }
        return sum;
    }
}
