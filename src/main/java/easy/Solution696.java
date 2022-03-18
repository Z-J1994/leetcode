package easy;

/**
 * @author zhangjun
 * @version 2022/3/18
 */
public class Solution696 {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int a = 0,b = 0;
        int p = -1;
        for(int i = 0,c;i < s.length();i++){
            c = s.charAt(i) - '0';
            if(p == c){
                b++;
            }else{
                count += Math.min(a,b);
                a = b;
                b = 1;
                p = c;
            }
        }
        count += Math.min(a,b);
        return count;
    }
    //00110011
    //10101

    public static void main(String[] args) {
        Solution696 s = new Solution696();
        System.out.println(s.countBinarySubstrings("00110011") == 6);
        System.out.println(s.countBinarySubstrings("10101") == 4);
        System.out.println(s.countBinarySubstrings("01") == 1);
    }
}
