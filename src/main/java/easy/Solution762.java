package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  23:06
 */
public class Solution762 {

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L;i <= R;i++){
            if(calculate(i)){
                count++;
            }
        }

        return count;
    }

    private boolean calculate(int n){
        int count = Integer.bitCount(n);
        if(count == 1){
            return false;
        }
        for(int i = 2;i <= Math.sqrt(count);i++){
            if(count % i == 0){
                return false;
            }
        }
        return true;
    }
}
