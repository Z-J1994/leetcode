package hard;

/**
 * @author zhangjun
 * @version 2022/10/18
 */
public class Solution902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int length = 0;
        for (int i = n; i > 0; i /= 10, length++) ;
        int[] ns = new int[length];
        for (int i = n, j = length - 1; i > 0; i /= 10, j--) {
            ns[j] = i % 10;
        }
        int[] numberDigit = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            numberDigit[i] = digits[i].charAt(0) - '0';
        }
        int c;
        if(numberDigit.length != 1){
            c = (int)((Math.pow(numberDigit.length,ns.length) - numberDigit.length) / (numberDigit.length - 1));
        }else{
            c = ns.length - 1;
        }
        if(numberDigit[0] > ns[0]){
            return c;
        }
        int t = 0;
        for (int i = 0, j; i < ns.length; i++) {
            for (j = 0; j < numberDigit.length && numberDigit[j] < ns[i]; j++);
            if(j != 0){
                c += j  * (Math.pow(numberDigit.length,ns.length - i - 1));
            }
            if(j < numberDigit.length && numberDigit[j] == ns[i]){
                t++;
            }else{
                break;
            }
        }
        return t < ns.length ? c : c + 1;
    }

    public static void main(String[] args) {
        Solution902 s = new Solution902();
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100) == 20);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000) == 29523);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"7"}, 8) == 1);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"3","4","8"}, 4) == 2);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1","3","5"}, 135) == 18);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"9"}, 55) == 1);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"5","6"}, 19) == 2);
        System.out.println(s.atMostNGivenDigitSet(new String[]{"1"}, 834) == 3);
    }
}
