package easy;

public class Solution387 {
    public int firstUniqChar(String s) {
        int [] map = new int[26];
        char [] cs = s.toCharArray();
        for(int i = 0;i < cs.length;i++){
            ++map[cs[i] - 97];
        }
        for(int i = 0;i < cs.length;i++){
            if(map[cs[i] - 97] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution387 s = new Solution387();
        String str1 = "";
        String str2 = "l";
        String str3 = "leetcode";
        String str4 = "loveleetcode";
        System.out.println(s.firstUniqChar(str1));
        System.out.println(s.firstUniqChar(str2));
        System.out.println(s.firstUniqChar(str3));
        System.out.println(s.firstUniqChar(str4));
    }
}
