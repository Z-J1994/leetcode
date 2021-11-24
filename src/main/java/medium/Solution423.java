package medium;

public class Solution423 {
    /**
     * zero one two three four five six seven eight nine
     * 题目保证一定存在答案,所以存在以下关系
     * z -> 0
     * w -> 2
     * u -> 4
     * x -> 6
     * g -> 8
     * f只在four和five中出现,当排除所有four之后还存在f则可推断出
     * 含有five.
     * r只在four和three中出现,当排除所有four之后还存在r则可推断出
     * 含有three
     * s只在six和seven中出现,排除所有six之后还存在s则可推断出含有
     * seven
     * o只在zero和one,two,four中出现,排除所有zero,two,four还
     * 存在o则可推断出含有one
     * n只在one和seven,nine中出现,排除所有one,seven之后还有n
     * 则可推断出含有nine
     * 综上所述0,2,4,6,8四个数字可以由单个字母唯一确定,所以它们
     * 判断的顺序不需要特别处理,3和5需要在4之后判断,7在6之后,
     * 1在0,2,4之后,9在1,7之后
     */
    public String originalDigits(String s) {
        int[] alphabet = new int[26];
        int length = s.length();
        for (char c : s.toCharArray()) {
            ++alphabet[c - 97];
        }
        int[] numbers = new int[10];

        //0
        int t = alphabet['z' - 97];
        numbers[0] += t;
        alphabet['z' - 97] -= t;
        alphabet['e' - 97] -= t;
        alphabet['r' - 97] -= t;
        alphabet['o' - 97] -= t;

        //2
        t = alphabet['w' - 97];
        numbers[2] += t;
        alphabet['t' - 97] -= t;
        alphabet['w' - 97] -= t;
        alphabet['o' - 97] -= t;

        //4
        t = alphabet['u' - 97];
        numbers[4] += t;
        alphabet['f' - 97] -= t;
        alphabet['o' - 97] -= t;
        alphabet['u' - 97] -= t;
        alphabet['r' - 97] -= t;

        //3
        t = alphabet['r' - 97];
        numbers[3] += t;
        alphabet['t' - 97] -= t;
        alphabet['h' - 97] -= t;
        alphabet['r' - 97] -= t;
        alphabet['e' - 97] -= 2 * t;

        //5
        t = alphabet['f' - 97];
        numbers[5] += t;
        alphabet['f' - 97] -= t;
        alphabet['i' - 97] -= t;
        alphabet['v' - 97] -= t;
        alphabet['e' - 97] -= t;

        //6
        t = alphabet['x' - 97];
        numbers[6] += t;
        alphabet['s' - 97] -= t;
        alphabet['i' - 97] -= t;
        alphabet['x' - 97] -= t;

        //7
        t = alphabet['s' - 97];
        numbers[7] += t;
        alphabet['s' - 97] -= t;
        alphabet['e' - 97] -= 2 * t;
        alphabet['v' - 97] -= t;
        alphabet['n' - 97] -= t;

        //8
        t = alphabet['g' - 97];
        numbers[8] += t;
        alphabet['e' - 97] -= t;
        alphabet['i' - 97] -= t;
        alphabet['g' - 97] -= t;
        alphabet['h' - 97] -= t;
        alphabet['t' - 97] -= t;

        //1
        t = alphabet['o' - 97];
        numbers[1] += t;
        alphabet['o' - 97] -= t;
        alphabet['n' - 97] -= t;
        alphabet['e' - 97] -= t;

        //9
        numbers[9] += alphabet['n' - 97] / 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (numbers[i]-- > 0) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
