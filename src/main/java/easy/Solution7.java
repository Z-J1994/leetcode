package easy;

public class Solution7 {
    public int reverse(int x) {

        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x /= 10;
        }

        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int)result;
    }

    public static void main(String[] args) {
        Solution7 s = new Solution7();

        int n1 = 123;
        int n2 = -123;
        int n3 = 120;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        int n6 = 1534236469;

        System.out.println(s.reverse(n1));
        System.out.println(s.reverse(n2));
        System.out.println(s.reverse(n3));
        System.out.println(s.reverse(n4));
        System.out.println(s.reverse(n5));
        System.out.println(s.reverse(n6));
    }
}
