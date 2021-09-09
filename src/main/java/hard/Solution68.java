package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/9/9
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = -1;
        int start = 0;
        List<String> result = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            count += words[i].length() + 1;
            if (count > maxWidth) {
                String s = getString(words, maxWidth, start, i - 1, count - words[i].length() - 1);
                result.add(s);
                count = words[i].length();
                start = i;
            } else if (count == maxWidth) {
                String s = getString(words, maxWidth, start, i, count);
                result.add(s);
                count = -1;
                start = i + 1;
            }
        }
        if (count != -1) {
            char [] chars = new char[maxWidth];
            int index = 0;
            for(int i = start;i < length;i++){
                String s = words[i];
                for(int k = 0,l = s.length();k < l;k++){
                    chars[index++] = s.charAt(k);
                }
                if(index < maxWidth){
                    chars[index++] = ' ';
                }
            }
            while(index < maxWidth){
                chars[index++] = ' ';
            }
            result.add(new String(chars));
        }

        return result;
    }

    private String getString(String[] words, int maxWidth, int lo, int hi, int count) {
        char[] chars = new char[maxWidth];
        int i = -1;
        String s = words[lo++];
        int l = s.length();
        while (++i < l) {
            chars[i] = s.charAt(i);
        }
        int ws = hi - lo + 1;
        int spaces = maxWidth - count + ws;

        if (ws == 0) {
            ws = 1;
        }
        int remainder = spaces % ws;
        int average = spaces / ws;

        for (int j = lo; j <= hi; j++) {
            for (int k = 0; k < average; k++) {
                chars[i++] = ' ';
            }
            if (remainder-- > 0) {
                chars[i++] = ' ';
            }
            s = words[j];
            l = s.length();
            for (int k = 0; k < l; k++) {
                chars[i++] = s.charAt(k);
            }
        }
        while(i < maxWidth){
            chars[i++] = ' ';
        }
        return new String(chars);
    }
}
