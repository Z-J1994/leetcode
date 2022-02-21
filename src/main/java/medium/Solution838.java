package medium;

/**
 * @author zhangjun
 * @version 2022/2/21
 */
public class Solution838 {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int[] mark = new int[dominoes.length()];
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        int l = -1, r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                left[++l] = i;
            } else if (chars[i] == 'R') {
                right[++r] = i;
            }
        }
        int count = 1;
        while (l >= 0 || r >= 0) {
            for (int i = 0; i <= l; i++) {
                if (left[i] == 0 || chars[left[i] - 1] != '.' || chars[left[i]] == '.') {
                    int t = left[l];
                    left[l] = left[i];
                    left[i] = t;
                    --l;
                    --i;
                } else {
                    chars[left[i] - 1] = 'L';
                    mark[left[i] - 1] = count;
                    if (--left[i] <= 0) {
                        int t = left[l];
                        left[l] = left[i];
                        left[i] = t;
                        --l;
                        --i;
                    }
                }
            }

            for (int i = 0; i <= r; i++) {
                char c;
                if (right[i] + 1 == chars.length || (c = chars[right[i] + 1]) == 'R' || chars[right[i]] == '.') {
                    int t = right[r];
                    right[r] = right[i];
                    right[i] = t;
                    --r;
                    --i;
                } else {
                    if (c == 'L' && count == mark[right[i] + 1]) {
                        chars[right[i] + 1] = '.';
                        ++right[i];
                    } else if (c == '.') {
                        chars[right[i] + 1] = 'R';
                        mark[right[i] + 1] = count;
                        if (++right[i] == chars.length - 1) {
                            int t = right[r];
                            right[r] = right[i];
                            right[i] = t;
                            --r;
                            --i;
                        }
                    }else{
                        int t = right[r];
                        right[r] = right[i];
                        right[i] = t;
                        --r;
                        --i;
                    }
                }
            }
            ++count;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution838 s = new Solution838();
        System.out.println("RR.L".equals(s.pushDominoes("RR.L")));
        System.out.println("LL.RR.LLRRLL..".equals(s.pushDominoes(".L.R...LR..L..")));
    }
}
