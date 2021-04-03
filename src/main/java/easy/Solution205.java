package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/12/27/ 8:19
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if(length != t.length()){
            return false;
        }
        char []maps = new char[128];
        char []mapt = new char[128];
        char [] cs = s.toCharArray();
        char [] ct = t.toCharArray();

        for(int i = 0;i < length;i++){
            char c = cs[i];
            char c1 = ct[i];
            char m = maps[c];
            char m1 = mapt[c1];
            if(m == 0){
                if(m1 != 0){
                    return false;
                }
                maps[c] = c1;
                mapt[c1] = c;
            }else if(m != c1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 s = new Solution205();
        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        String s4 = "ab";
        String t4 = "aa";

        String s5 = "13";
        String t5 = "42";

        System.out.println(s.isIsomorphic(s1,t1));//true
        System.out.println(s.isIsomorphic(s2,t2));//false
        System.out.println(s.isIsomorphic(s3,t3));//true
        System.out.println(s.isIsomorphic(s4,t4));//false
        System.out.println(s.isIsomorphic(s5,t5));//true
    }
}
