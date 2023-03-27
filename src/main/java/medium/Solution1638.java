package medium;

/**
 * @author zhangjun
 * @version 2023/3/27
 */
public class Solution1638 {

    public int countSubstrings(String s, String t) {
        int sum = 0;
        char [] cs = s.toCharArray();
        char [] ts = t.toCharArray();
        for(int i = 0,l = s.length();i < l;i++){
            for(int j = i;j < l;j++){
                sum += match(cs,i,j,ts);
            }
        }
        return sum;
    }
    private int match(char [] s,int start,int end,char [] t){
        int sum = 0;
        for(int i = 0,l = t.length - (end - start);i < l;i++){
            int c = 0;
            for(int j = start,k = i;j <= end;j++,k++){
                if(s[j] != t[k]){
                    if(++c > 1){
                        break;
                    }
                }
            }
            if(c == 1){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1638 s = new Solution1638();
        System.out.println(s.countSubstrings("aba", "baba"));
    }
}
