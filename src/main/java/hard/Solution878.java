package hard;

/**
 * @author zhangjun
 * @version 2022/11/22
 */
public class Solution878 {
    public int nthMagicalNumber(int n, int a, int b) {
        if(a > b){
            int t = a;
            a = b;
            b = t;
        }
        long lo = a,hi = (long) b * n,t;
        int lcm = lcm(b,a);
        while(lo <= hi){
            long mid = (lo + hi) >>> 1;
            t = mid / a + mid / b - mid / lcm;
            if(t == n){
                return (int)(Math.max(mid / a * a,mid / b * b) % 1000000007);
            }else if(t > n){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int lcm(int a,int b){
        return a * b / gcd(a,b);
    }

    private int gcd(int a,int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution878 s = new Solution878();
        System.out.println(s.nthMagicalNumber(1, 2, 3));
    }
}
