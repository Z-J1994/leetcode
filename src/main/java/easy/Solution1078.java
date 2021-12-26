package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/12/26
 */
public class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        char [] cs = new char[first.length() + second.length() + 3];
        cs[0] = ' ';
        cs[cs.length - 1] = ' ';
        int i;
        for(i = 0;i < first.length();i++){
            cs[i + 1] = first.charAt(i);
        }
        cs[i + 1] = ' ';
        i = 0;
        for(int t = first.length() + 2;i < second.length();i++){
            cs[t + i] = second.charAt(i);
        }
        char [] ts = text.toCharArray();

        for(i = 1;i < cs.length;i++){
            if(cs[i] != ts[i - 1]){
                break;
            }
        }
        if(i == cs.length){
            String s = getNext(ts,i - 1);
            if(s != null){
                result.add(s);
            }
        }
        i = 0;
        for(int j,l = ts.length - cs.length;i < l;i++){
            for(j = 0;j < cs.length;j++){
                if(cs[j] != ts[i + j]){
                    break;
                }
            }
            if(j == cs.length){
                String s = getNext(ts,i + j);
                if(s != null){
                    result.add(s);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private String getNext(char [] ts,int index){
        int i;
        for(i = index;i < ts.length && ts[i] != ' ';i++);
        if(i == index){
            return null;
        }
        return new String(ts,index,(i - index));
    }

    public static void main(String[] args) {
        Solution1078 s = new Solution1078();
        System.out.println(Arrays.toString(s.findOcurrences("we will we will rock you", "we", "will")));
    }
}
