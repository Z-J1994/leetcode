package medium;

/**
 * @author zhangjun
 * @since 2022/6/7 12:33
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1,hi = 1;
        for(int pile : piles){
            if(pile > hi){
                hi = pile;
            }
        }
        hi += 1;
        int mid;
        while(lo < hi){
            mid = (lo + hi) >>> 1;
            if(check(piles,h,mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean check(int[] piles, int h,int k){
        int t = k - 1;
        for(int pile : piles){
            h -= (pile + t) / k;
        }
        return h >= 0;
    }
}
