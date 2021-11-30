package medium;

public class Solution400 {
    public int findNthDigit(int n) {
        long lo = 0,hi = 10;
        long hiCount = 0;
        int numberCount = 1;
        while(true){
            hiCount += (hi - lo) * numberCount;
            if(hiCount > n){
                break;
            }
            numberCount++;
            lo = hi;
            hi *= 10;
        }
        hiCount = hiCount - n - 1;
        hi = hi - (hiCount / numberCount) - 1;
        long k = hiCount % numberCount;

        while(k > 0){
            hi /= 10;
            k--;
        }
        return (int)(hi % 10);
    }

}
