package easy;

/**
 * @author zhangjun
 * @version 2022/3/11
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1, l = length >>> 1; i <= l; i++) {
            if (length % i == 0) {
                boolean f = true;
                for (int j = 0; j < i && f; j++) {
                    char c = s.charAt(j);
                    for (int k = j + i; k < length; k += i) {
                        if (c != s.charAt(k)) {
                            f = false;
                            break;
                        }
                    }
                }
                if(f){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution459 s = new Solution459();
        System.out.println(s.repeatedSubstringPattern("abacababacab"));
    }
}
