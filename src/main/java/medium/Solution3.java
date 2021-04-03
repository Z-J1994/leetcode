package medium;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        char [] value = s.toCharArray();
        int [] map = new int[128];
        int max = 0;

        for(int i = 0;i < 128;i++){
            map[i] = -1;
        }

        for(int i = 0,length = value.length,m = 0,t = 0;i < length;i++){
            char c = value[i];
            int j = map[c];
            if(j >= m){
                m = j;
                t = i - m;
            }else{
                ++t;
                if(t > max){
                    max = t;
                }
            }
            map[c] = i;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "";
        String s5 = "dvdf";
        String s6 = "au";

        System.out.println(s.lengthOfLongestSubstring(s1));//3
        System.out.println(s.lengthOfLongestSubstring(s2));//1
        System.out.println(s.lengthOfLongestSubstring(s3));//3
        System.out.println(s.lengthOfLongestSubstring(s4));//0
        System.out.println(s.lengthOfLongestSubstring(s5));//3
        System.out.println(s.lengthOfLongestSubstring(s6));//2

    }
}
