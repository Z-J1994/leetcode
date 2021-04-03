package easy;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int lg = g.length;
        int ls = s.length;
        for(int i = 0;count < lg && i < ls;i++){
            if(s[i] >= g[count]){
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution455 s = new Solution455();
        int [] g1 = {1,2,3};
        int [] s1 = {1,1};

        int [] g2 = {1,2,};
        int [] s2 = {1,2,3};

        int [] g3 = {};
        int [] s3 = {1,2,3};

        System.out.println(s.findContentChildren(g1,s1));
        System.out.println(s.findContentChildren(g2,s2));
        System.out.println(s.findContentChildren(g3,s3));
    }
}
