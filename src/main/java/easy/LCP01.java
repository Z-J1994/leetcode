package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:16
 */
public class LCP01 {
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for(int i = 0;i < 3;i++){
            if(guess[i] == answer[i]){
                count++;
            }
        }
        return count;
    }
}
