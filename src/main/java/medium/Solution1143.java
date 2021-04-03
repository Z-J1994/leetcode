package medium;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();
        int [] result = new int[length2 + 1];
        char [] t1 = text1.toCharArray();
        char [] t2 = text2.toCharArray();
        for(int i = 1;i <= length1;i++){
            int previous = result[0];
            for(int j = 1;j <= length2;j++){
                int t = result[j];
                if(t1[i - 1] == t2[j - 1]){
                    result[j] = previous + 1;
                }else if(result[j - 1] > result[j]){
                    result[j] = result[j - 1];
                }
                previous = t;
            }
        }
        return result[length2];
    }

    public static void main(String[] args) {
        Solution1143 s = new Solution1143();
        String t1 = "abcde";
        String t2 = "abc";
        System.out.println(s.longestCommonSubsequence(t1,t2));
    }
}
