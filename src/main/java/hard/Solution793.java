package hard;

public class Solution793 {
    public int preimageSizeFZF(int k) {
        long lo = 1,hi = k * 5L + 1;
        while(lo <= hi){
            long mid = (lo + hi) >>> 1;
            int r = getZero(mid);
            if(r == k){
                return 5;
            }else if(r < k){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return 0;
    }

    private static int getZero(long n){
        int c = 0;
        while(n > 0){
            n /= 5;
            c += n;
        }
        return c;
    }
}
