package easy;

/**
 * @author zhangjun
 * @version 2022/11/11
 */
public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() >>> 1;
        return get(s,0,mid) == get(s,mid,s.length());
    }
    private int get(String s,int start,int end){
        int count = 0;
        while(start < end){
            switch (s.charAt(start++)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> count++;
            }
        }
        return count;
    }
}
