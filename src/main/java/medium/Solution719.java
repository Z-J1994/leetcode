package medium;

public class Solution719 {
    public String customSortString(String order, String s) {
        int ol = order.length();
        int sl = s.length();
        int [] map = new int[ol];
        for(int i = 0;i < ol;i++){
            map[i] = order.charAt(i) - 'a';
        }
        int [] chars = new int[26];
        for(int i = 0;i < sl;i++){
            chars[s.charAt(i) - 'a']++;
        }
        char [] resultC = new char[sl];
        int index = 0;
        for(int i = 0;i < ol;i++){
            for(int j = 0,t = chars[map[i]];j < t;j++){
                resultC[index++] = (char)(map[i] + 'a');
            }
            chars[map[i]] = 0;
        }
        for(int i = 0;i < 26;i++){
            for(int j = 0,t = chars[i];j < t;j++){
                resultC[index++] = (char)(i + 'a');
            }
            chars[i] = 0;
        }
        return new String(resultC);
    }

    public static void main(String[] args) {
        Solution719 s = new Solution719();
        System.out.println(s.customSortString("cba", "abcd"));
    }
}
