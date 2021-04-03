package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        char sv = ' ';
        int start = 0;
        int length = s.length() - 1;
        for(int i = 0;i <= length;i++){
            char c = s.charAt(i);
            if(sv != c){
                if(i - start >= 3){
                    result.add(Arrays.asList(start, i - 1));
                }
                start = i;
                sv = c;
            }
        }
        if(length - start >= 2){
            result.add(Arrays.asList(start, length));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution830 s = new Solution830();
        String s1 = "abbxxxxzzy";
        String s2 = "abc";
        String s3 = "abcdddeeeeaabbbcd";
        String s4 = "aba";
        String s5 = "xxxxxxxxxx";

        System.out.println(s.largeGroupPositions(s1).toString());
        System.out.println(s.largeGroupPositions(s2).toString());
        System.out.println(s.largeGroupPositions(s3).toString());
        System.out.println(s.largeGroupPositions(s4).toString());
        System.out.println(s.largeGroupPositions(s5).toString());
    }
}
