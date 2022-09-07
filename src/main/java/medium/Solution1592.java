package medium;

/**
 * @author zhangjun
 * @since 2022/9/7 13:28
 */
public class Solution1592 {
    public String reorderSpaces(String text) {
        int length = text.length();
        char[] chars = new char[length];
        int whiteSpaces = 0;
        int words = 0;
        for (int i = 0; i < length; i++) {
            chars[i] = text.charAt(i);
            if (chars[i] == ' ') {
                whiteSpaces++;
            } else if (i == 0 || chars[i - 1] == ' ') {
                words++;
            }
        }
        if (whiteSpaces == 0) {
            return text;
        }
        if(words > 1){
            whiteSpaces /= words - 1;
        }
        int i = 0;
        int j = 0;
        char c;
        while (j < length && i < length) {
            while (j < length && text.charAt(j) == ' ') {
                j++;
            }
            while (j < length && (c = text.charAt(j++)) != ' ') {
                chars[i++] = c;
            }
            for (int k = 0; i < length && k < whiteSpaces; k++, i++) {
                chars[i] = ' ';
            }
        }
        while(i < length){
            chars[i++] = ' ';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution1592 s = new Solution1592();
//        System.out.println(s.reorderSpaces("  this   is  a sentence "));
//        System.out.println(s.reorderSpaces(" practice   makes   perfect"));
//        System.out.println(s.reorderSpaces("hello   world"));
//        System.out.println(s.reorderSpaces("  walks  udp package   into  bar a"));
//        System.out.println(s.reorderSpaces("a"));
        System.out.println(s.reorderSpaces("  hello"));

    }
}
