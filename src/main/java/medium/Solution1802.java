package medium;

/**
 * @author zhangjun
 * @version 2023/1/4
 */
public class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 0,hi = maxSum;
        while(lo < hi){
            int mid = (lo + 1 + hi) >>> 1;
            long t = calculate(mid,index,n);
            if(t <= maxSum){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }

    private long calculate(int x,int index,int n){
        return calculate(x,index) + calculate(x,n - index - 1) - x;
    }

    private long calculate(long x,long index){
        long t;
        if(x > index){
            t = (x * (index + 1)) - (((index + 1) * index) / 2);
        }else{
            t = ((1 + x) * x) / 2 + index - x + 1;
        }
        return t;
    }

    public static void main(String[] args) {
        Solution1802 s = new Solution1802();
        System.out.println(s.maxValue(6, 1, 10) == 3);
        System.out.println(s.maxValue(1000000, 8767, 1000000000) == 37620);
        System.out.println(s.maxValue(4, 0, 4) == 1);
    }
}
