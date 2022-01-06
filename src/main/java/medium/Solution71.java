package medium;

import java.nio.file.Paths;

/**
 * @author zhangjun
 * @version 2022/1/6
 */
public class Solution71 {
    public String simplifyPath(String path) {
        char[] chars = path.toCharArray();
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (chars[index] == '/') {
                    continue;
                }
                chars[++index] = chars[i];
            } else if (chars[i - 1] == '/' && chars[i] == '.') {
                chars[++index] = '.';
                int t = i;
                while (++i < chars.length && chars[i] == '.') {
                    chars[++index] = '.';
                }
                t = i - t;
                if (t == 1) {
                    if((i < chars.length && chars[i] == '/') || i == chars.length){
                        index--;
                    }
                } else if (t == 2) {
                    if((i < chars.length && chars[i] == '/') || i == chars.length){
                        index -= 2;
                        if(index != 0){
                            //第一个元素必定是'/',可以忽略边界检查
                            while (chars[--index] != '/');
                        }
                    }
                }
                i--;
            } else {
                chars[++index] = chars[i];
            }
        }
        if (chars[index] != '/' || index == 0) {
            index++;
        }
        return new String(chars, 0, index);
    }

    public static void main(String[] args) {
        Solution71 s = new Solution71();
        System.out.println(s.simplifyPath("/home/.../"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/..hidden"));
        System.out.println(s.simplifyPath("/.."));
        System.out.println(s.simplifyPath("/hello../world"));
    }
}
