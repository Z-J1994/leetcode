package easy;

/**
 * @author zhangjun
 * @version 2020/10/03  21:56
 */
public class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        for (int i = 0, k = searchWord.length(), l = sentence.length() - k, j = 0, index = 1; i <= l; j = 0, index++) {
            for (; j < k && sentence.charAt(i) == searchWord.charAt(j); i++, j++);
            if (j == k) {
                return index;
            }
            while (i <= l && sentence.charAt(i++) != ' ');
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution1455 s = new Solution1455();
        System.out.println(s.isPrefixOfWord("i love eating burger", "burg") == 4);
        System.out.println(s.isPrefixOfWord("this problem is an easy problem", "pro") == 2);
        System.out.println(s.isPrefixOfWord("hellohello hellohellohello", "ell") == -1);
    }
}
