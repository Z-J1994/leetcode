package medium;

public class Solution788 {
    private final int [] map = {0,1,5,-1,-1,2,9,-1,8,6};

    public int rotatedDigits(int n) {
        int c = 0;
        for(int i = 1;i <= n;i++){
            if(check(i)){
                c++;
            }
        }
        return c;
    }

    private boolean check(int x){
        int y = 0;
        for(int i = x,t = 1,c;i > 0;i /= 10,t *= 10){
            c = map[i % 10];
            if(c < 0){
                return false;
            }
            y = c * t + y;
        }
        return y != x;
    }
}
