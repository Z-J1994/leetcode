package medium;

/**
 * @author zhangjun
 * @version 2021/9/1
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
        int i1 = -1;
        int i2 = -1;
        int length1 = version1.length();
        int length2 = version2.length();
        while(i1 < length1 || i2 < length2){
            int s1 = 0;
            while(++i1 < length1 && version1.charAt(i1) != '.'){
                s1 = s1 * 10 + (version1.charAt(i1) - 48);
            }

            int s2 = 0;
            while(++i2 < length2 && version2.charAt(i2) != '.'){
                s2 = s2 * 10 + (version2.charAt(i2) - 48);
            }
            if(s1 != s2){
                return s1 - s2 > 0 ? 1 : -1;
            }
        }
        return 0;
    }
}
