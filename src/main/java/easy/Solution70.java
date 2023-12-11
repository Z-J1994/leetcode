package easy;

public class Solution70 {
    public int climbStairs(int n) {
        int c = 0;
        for(int i = 1,a = 0,b = 1;i <= n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution70 s = new Solution70();
        System.out.println(s.climbStairs(1));
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
    }
}
