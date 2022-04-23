package easy;

public class Solution868 {
    public int binaryGap(int n) {
        int max = 0;
        int i = 32;
        while(i-- > 0 && ((n >> i) & 1) == 0);
        int t = 0;
        while(--i >= 0){
            t++;
            if(((n >> i) & 1)  == 1){
                max = Math.max(t,max);
                t = 0;
            }
        }
        return max;
    }
}
