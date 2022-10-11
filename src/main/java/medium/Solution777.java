package medium;

public class Solution777 {
    public boolean canTransform(String start, String end) {
        char[] chars = start.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = end.charAt(i);
            if (c != chars[i]) {
                if (c == 'L') {
                    if (chars[i] == 'X') {
                        int n = i + 1;
                        while (n < chars.length && chars[n] == 'X') {
                            n++;
                        }
                        if (n >= chars.length || chars[n] != 'L') {
                            return false;
                        }
                        chars[n] = 'X';
                        chars[i] = 'L';
                    } else {
                        return false;
                    }
                } else if (c == 'X') {
                    if (chars[i] == 'R') {
                        int n = i + 1;
                        while (n < chars.length && chars[n] == 'R') {
                            n++;
                        }
                        if (n >= chars.length || chars[n] != 'X') {
                            return false;
                        }
                        chars[n] = 'R';
                        chars[i] = 'X';
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution777 s = new Solution777();
//        System.out.println(s.canTransform("RXXLRXRXL", "XRLXXRRLX"));
//        System.out.println(s.canTransform("RXR","XXR"));
        System.out.println(s.canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
    }
}
