package hard;

/**
 * @author zhangjun
 * @since 2022/9/6 13:14
 */
public class Solution828 {
    public int uniqueLetterString(String s) {
        int count = 0;
        //map[i][0] 表示上一个相同字母的下标
        //map[i][1] 表示上一个相同字母与上上一个相同字母中间的字母数量
        int [][] map = new int[26][2];
        int length = s.length();
        for(int i = 0;i < 26;i++){
            map[i][0] = -1;
        }
        for(int i = 0,t,j;i < length;i++){
            j = s.charAt(i) - 'A';
            t = i - map[j][0];
            map[j][0] = i;
            count += t * map[j][1];
            map[j][1] = t;
        }
        for(int i = 0,l = s.length(),t;i < 26;i++){
            t = l - map[i][0];
            map[i][0] = i;
            count += t * map[i][1];
            map[i][1] = t;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution828 s = new Solution828();
        System.out.println(s.uniqueLetterString("ABC") == 10);
        System.out.println(s.uniqueLetterString("ABA") == 8);
        System.out.println(s.uniqueLetterString("LEETCODE") == 92);
        System.out.println(s.uniqueLetterString("ABABABABABABABABABABABABABABBBABAB") == 133);
    }
}
