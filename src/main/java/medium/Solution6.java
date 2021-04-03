package medium;

import java.util.Arrays;

public class Solution6 {
    public String convert(String s, int numRows) {
        int length = s.length();
        if(length <= numRows || numRows == 1){
            return s;
        }
        char [] values = new char[length];
        char [] str = s.toCharArray();
        int index = 0;
        int step = (numRows - 1) * 2;

        for(int j = 0;j < length;j += step){
            values[index++] = str[j];
        }

        int l = step;
        for(int i = 1;i < numRows - 1;i++){
            l -= 2;
            for(int j = i;j < length;j += step){
                values[index++] = str[j];
                if(j + l < length){
                    values[index++] = str[j + l];
                }
            }
        }

        for(int j = numRows - 1;j < length;j += step){
            values[index++] = str[j];
        }

        System.out.println(Arrays.toString(values));
        return new String(values);
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();

        String str1 = "LEETCODEISHIRING";
        int num1 = 3;

        String str2 = "LEETCODEISHIRING";
        int num2 = 4;

        String str3 = "AB";
        int num3 = 1;

        System.out.println(s.convert(str1,num1).equals("LCIRETOESIIGEDHN"));

        System.out.println(s.convert(str2,num2).equals("LDREOEIIECIHNTSG"));
        System.out.println(s.convert(str3,num3).equals("LDREOEIIECIHNTSG"));

    }
}
