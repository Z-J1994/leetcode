package medium;

public class Solution6 {
//    public String convert(String s, int numRows) {
//        int length = s.length();
//        if (length <= numRows || numRows == 1) {
//            return s;
//        }
//        char[] values = new char[length];
//        char[] str = s.toCharArray();
//        int index = 0;
//        int step = (numRows - 1) * 2;
//
//        for (int j = 0; j < length; j += step) {
//            values[index++] = str[j];
//        }
//
//        int l = step;
//        for (int i = 1; i < numRows - 1; i++) {
//            l -= 2;
//            for (int j = i; j < length; j += step) {
//                values[index++] = str[j];
//                if (j + l < length) {
//                    values[index++] = str[j + l];
//                }
//            }
//        }
//
//        for (int j = numRows - 1; j < length; j += step) {
//            values[index++] = str[j];
//        }
//        return new String(values);
//    }

    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || numRows > length) {
            return s;
        }
        char[] chars = new char[s.length()];
        int index = 0;
        int step = (numRows - 1) * 2;
        for (int i = 0;i < length; i += step) {
            chars[index++] = s.charAt(i);
        }
        for (int j = 1, d = step,t = 0; j < numRows - 1; j++) {
            d -= 2;
            t += 2;
            for (int i = j, c = 0; i < length; c++) {
                chars[index++] = s.charAt(i);
                if((c & 1) == 0){
                    i += d;
                }else{
                    i += t;
                }
            }
        }
        for (int i = numRows - 1;i < length; i += step) {
            chars[index++] = s.charAt(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(s.convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
        System.out.println(s.convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(s.convert("AB", 1).equals("AB"));

    }
}
