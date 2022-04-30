package easy;

public class Solution1009 {
    public int bitwiseComplement(int n) {
        if(n == 0){
            return 1;
        }
        int mask = 0x80000000;
        int i = 0;
        while(((mask >> ++i) & n) == 0);

        return (-1 >>> i) & (~n);
    }
}
