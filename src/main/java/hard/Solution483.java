package hard;

/**
 * @author zhangjun
 * @version 2021/6/18
 */
public class Solution483 {
    public String smallestGoodBase(String n) {
        long number = 0;
        int length = n.length() - 1;
        for(int i = 0;i <= length;i++){
            number = number * 10 + (n.charAt(i) - 48);
        }
        for(int i = bitCount(number);i >= 1;i--){
            long lo = 2;
            long hi = number - 1;
            while(lo <= hi){
                long mid = lo + (hi - lo) / 2;
                long t = 0;
                long limit = (Long.MAX_VALUE - 1) / mid;
                for(int k = 0;k < i;k++){
                    if(t > limit){
                        t = -1;
                        break;
                    }
                    t = t * mid + 1;
                }
                if(t < 0 || t > number){
                    hi = mid - 1;
                }else if(t < number){
                    lo = mid + 1;
                }else{
                    return String.valueOf(mid);
                }
            }
        }
        return null;
    }

    private int bitCount(long x){
        x = (x & 0x5555555555555555L) + ((x >>> 1) & 0x5555555555555555L);
        x = (x & 0x3333333333333333L) + ((x >>> 2) & 0x3333333333333333L);
        x = (x & 0x0F0F0F0F0F0F0F0FL) + ((x >>> 4) & 0x0F0F0F0F0F0F0F0FL);
        x = (x & 0x00FF00FF00FF00FFL) + ((x >>> 8) & 0x00FF00FF00FF00FFL);
        x = (x & 0x0000FFFF0000FFFFL) + ((x >>> 16) & 0x0000FFFF0000FFFFL);
        x = (x & 0x00000000FFFFFFFFL) + ((x >>> 32) & 0x00000000FFFFFFFFL);

        return (int)x;
    }
}
