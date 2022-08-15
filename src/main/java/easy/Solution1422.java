package easy;

public class Solution1422 {
    public int maxScore(String s) {
        int oneCount = 0;
        for(int i = 0,l = s.length();i < l;i++){
            if(s.charAt(i) == '1'){
                oneCount++;
            }
        }
        int zeroCount = 0;
        int max = 0;

        for(int i = 0,l = s.length() - 1;i < l;i++){
            if(s.charAt(i) == '1'){
                oneCount--;
            }else{
                zeroCount++;
            }
            max = Math.max(oneCount + zeroCount,max);
        }
        return max;
    }
}
