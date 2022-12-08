package easy;

/**
 * @author zhangjun
 * @version 2022/12/8
 */
public class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a' +  coordinates.charAt(1) - '0') & 1) == 0;
    }
}
