package easy;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x < 0 || x % 10 == 0){
            return false;
        }

        int t = 0;
        while(t < x){
            t = t * 10 + x % 10;
            x /= 10;
        }
        return x == t || t / 10 == x;
    }

    public static void main(String[] args) {
        Solution9 s = new Solution9();
        int t1 = 121;
        int t2 = -121;
        int t3 = 10;


        System.out.println(s.isPalindrome(t1));
        System.out.println(s.isPalindrome(t2));
        System.out.println(s.isPalindrome(t3));
    }
}
