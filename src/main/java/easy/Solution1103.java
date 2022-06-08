package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2022/6/8 12:57
 */
public class Solution1103 {
    public int[] distributeCandies(int candies, int numPeople) {
        int lo = 0,hi = candies;
        while(lo < hi){
            // +1 可以向上取整
            int mid = (lo + 1 + hi) >>> 1;
            if(calculate(mid) > candies){
                hi = mid - 1;
            }else{
                lo = mid;
            }
        }

        int time = lo / numPeople;
        int i = 0;
        int [] result = new int[numPeople];

        time++;
        for(int l = (lo % numPeople);i < l;i++){
            result[i] = time * (i + 1) + numPeople * (int)calculate(time - 1);
        }
        time--;
        int last = (int)(candies - calculate(lo));
        result[i] = last + time * (i + 1) + numPeople * (int)calculate(time - 1);
        while(++i < numPeople){
            result[i] = time * (i + 1) + numPeople * (int)calculate(time - 1);
        }
        return result;
    }

    private long calculate(long n){
        return (n + 1) * n / 2;
    }

    public static void main(String[] args) {
        Solution1103 s = new Solution1103();
        System.out.println(Arrays.toString(s.distributeCandies(7, 4)));
    }
}
