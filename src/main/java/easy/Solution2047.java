package easy;

/**
 * @author zhangjun
 * @version 2022/1/27
 */
public class Solution2047 {
    public int countValidWords(String sentence) {
        char previousAlphabet = ' ';
        int hyphen = 0;
        int other = 0;
        boolean valid = true;
        int sum = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (valid && hyphen >= 0 && other <= 1 && previousAlphabet != ' ') {
                    ++sum;
                }
                hyphen = 0;
                other = 0;
                valid = true;
            } else if (c >= 'a' && c <= 'z') {
                if (hyphen == -1 && previousAlphabet == '-') {
                    hyphen = 1;
                }
                if (other > 0) {
                    valid = false;
                }
            } else if (c == '-') {
                if (previousAlphabet < 'a' || previousAlphabet > 'z' || hyphen != 0) {
                    valid = false;
                }
                //遇到-暂时不能确认是否为合法字符串,所以先设置成-1,如果后面是字母则确认为合法状态,再设置为1;
                hyphen = -1;
            } else if (c == ',' || c == '.' || c == '!') {
                if (other > 0) {
                    valid = false;
                }
                ++other;
            } else {
                valid = false;
            }
            previousAlphabet = c;
        }
        if (valid && hyphen >= 0 && other <= 1 && previousAlphabet != ' ') {
            ++sum;
        }
        return sum;
    }
}
