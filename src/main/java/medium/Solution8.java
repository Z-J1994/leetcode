package medium;

import com.sun.security.jgss.GSSUtil;

public class Solution8 {
    public int myAtoi(String s) {
        int length = s.length();

        int start = 0;
        while(start < length && s.charAt(start) == ' '){
            start++;
        }

        if(start == length){
            return 0;
        }

        int sign = 1;
        char c = s.charAt(start);
        if(c == '-'){
            sign = -1;
            start++;
        }else if(c == '+'){
            start++;
        }

        while(start < length && s.charAt(start) == '0'){
            start++;
        }

        if(start == length){
            return 0;
        }

        int num = 0;
        int bit = 0;
        int k = s.charAt(start) - 48;
        while(start < length){
            int t = s.charAt(start++);
            if(t >= '0' && t <= '9'){
                num = num * 10 + t - 48;
                bit ++;
            }else{
                break;
            }
        }

        if(num < 0){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if((bit == 10 && k > 2) || bit > 10){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

       return num * sign;

    }

    public static void main(String[] args) {
        Solution8 s = new Solution8();
        String str1 = "43";
        String str2 = "   -43";
        String str3 = "4193 with words";
        String str4 = "-91283472332";
        String str5 = "words and 987";
        String str6 = "9223372036854775808";
        String str7 = "  0000000000012345678";
        String str8 = "  000000000000";
        String str9 = "1";

        System.out.println(s.myAtoi(str1));//43
        System.out.println(s.myAtoi(str2));//-43
        System.out.println(s.myAtoi(str3));//4193
        System.out.println(s.myAtoi(str4));//-2147483648
        System.out.println(s.myAtoi(str5));//0
        System.out.println(s.myAtoi(str6));//2147483647
        System.out.println(s.myAtoi(str7));//12345678
        System.out.println(s.myAtoi(str8));//0
        System.out.println(s.myAtoi(str9));//0
    }
}
