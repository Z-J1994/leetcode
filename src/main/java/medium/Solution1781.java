package medium;

/**
 * @author zhangjun
 * @version 2022/12/12
 */
public class Solution1781 {
    public int beautySum(String s) {
        char [] cs = s.toCharArray();
        int result = 0;
        for(int i = 1;i < cs.length;i++){
            int [] map = new int[26];
            for(int j = i;j >= 0;j--){
                map[cs[j] - 'a']++;
                int max = 0,min = 1000;
                for(int k = 0;k < 26;k++){
                    if(map[k] > max){
                        max = map[k];
                    }
                    if(map[k] != 0 && map[k] < min){
                        min = map[k];
                    }
                }
                result += max - min;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1781 s = new Solution1781();
        System.out.println(s.beautySum("aab"));
    }
}
