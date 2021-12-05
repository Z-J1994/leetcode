package medium;

public class Solution372 {

    public int superPow(int a, int[] b) {
        int result = 1;
        int unit = a % 1337;
        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * pow(unit, b[i])) % 1337;
            unit = pow(unit, 10) % 1337;
        }
        return result % 1337;
    }

    private int pow(int a, int b) {
        int result = 1;
        int u = a;
        while (b > 0) {
            if ((b & 0x1) == 1) {
                result = (u * result) % 1337;
            }
            u = (u * u) % 1337;
            b >>>= 1;
        }
        return result;
    }
}
