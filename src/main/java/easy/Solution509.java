package easy;

public class Solution509 {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int answer = 0;
        for(int i = 1,a = 0,b = 1;i < n;i++){
            answer = a + b;
            a = b;
            b = answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution509 s = new Solution509();
        System.out.println(s.fib(0));
        System.out.println(s.fib(1));
        System.out.println(s.fib(2));
        System.out.println(s.fib(3));
        System.out.println(s.fib(4));
        System.out.println(s.fib(5));
        System.out.println(s.fib(6));
    }
}
