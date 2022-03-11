package easy;

/**
 * @author zhangjun
 * @version 2022/3/11
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        char[] result = new char[Math.max(num1.length(), num2.length()) + 1];
        int index = result.length - 1, i, j;
        int carry = 0;
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--, index--) {
            result[index] = (char) (num1.charAt(i) + num2.charAt(j) - 48 + carry);
            carry = 0;
            if (result[index] > '9') {
                result[index] -= 10;
                carry = 1;
            }
        }
        while (i >= 0) {
            result[index] = (char) (num1.charAt(i--) + carry);
            carry = 0;
            if (result[index] > '9') {
                result[index] -= 10;
                carry = 1;
            }
            index--;
        }

        while (j >= 0) {
            result[index] = (char) (num2.charAt(j--)  + carry);
            carry = 0;
            if (result[index] > '9') {
                result[index] -= 10;
                carry = 1;
            }
            index--;
        }
        if (carry != 0) {
            result[index--] = '1';
        }
        ++index;
        return new String(result, index, result.length - index);
    }

    public static void main(String[] args) {
        Solution415 s = new Solution415();
//        System.out.println(s.addStrings("11", "123"));
//        System.out.println(s.addStrings("9", "9"));
        System.out.println(s.addStrings("9","99"));
    }
}
