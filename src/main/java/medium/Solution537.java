package medium;

/**
 * @author zhangjun
 * @version 2022/2/25
 */
public class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {
        int [] n1 = getNumbers(num1);
        int [] n2 = getNumbers(num2);
        return n1[0] * n2[0] - n1[1] * n2[1] + "+" + (n1[0] * n2[1] + n1[1] * n2[0]) + "i";
    }

    private int[] getNumbers(String s) {
        int[] result = new int[2];
        char[] chars = s.toCharArray();
        int index = 0;
        int sign = 1;
        char c;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        }
        while ((c = chars[index++]) >= '0' && c <= '9') {
            result[0] = result[0] * 10 + (c - 48);
        }
        result[0] *= sign;
        sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        }
        while ((c = chars[index++]) != 'i') {
            result[1] = result[1] * 10 + (c - 48);
        }
        result[1] *= sign;
        return result;
    }

    public static void main(String[] args) {
        Solution537 s = new Solution537();
        System.out.println(s.complexNumberMultiply("1+1i", "1+1i").equals("0+2i"));
        System.out.println(s.complexNumberMultiply("1+-1i", "1+-1i").equals("0+-2i"));
        System.out.println(s.complexNumberMultiply("100+-100i", "100+100i").equals("20000+0i"));
        System.out.println(s.complexNumberMultiply("78+-76i", "-86+72i").equals("-1236+12152i"));
    }
}
