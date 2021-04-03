package medium;

/**
 * @author zhangjun
 * @date 2021/2/10
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        char [] pattern = s1.toCharArray();
        char [] text = s2.toCharArray();
        int [] map = new int[128];
        int k = pattern.length;
        fill(map,pattern);
        boolean marked = false;
        for(int i = 0,j = 0,l = text.length,count = 0;j < l;j++){
            int t = map[text[j]];
            if(t == 0){
                j = i;
                i++;
                count = 0;
                if(marked){
                    fill(map,pattern);
                }
                marked = false;
            }else{
                marked = true;
                t--;
                map[text[j]] = t;
                count++;
                if(count == k){
                    return true;
                }
            }
        }
        return false;
    }

    private void fill(int [] map,char [] pattern){
        for(int i = 97;i < 122;i++){
            map[i] = 0;
        }

        for(int i = 0,l = pattern.length;i < l;i++){
            map[pattern[i]]++;
        }
    }

    public static void main(String[] args) {
        Solution567 s = new Solution567();
        String s1 = "ab";
        String s2 = "eidbaooo";

        String s3 = "ab";
        String s4 = "eidboaoo";

        String s5 = "adc";
        String s6 = "dcda";

        System.out.println(s.checkInclusion(s1,s2));//true;
        System.out.println(s.checkInclusion(s3,s4));//false;
        System.out.println(s.checkInclusion(s5,s6));//true;
    }
}
