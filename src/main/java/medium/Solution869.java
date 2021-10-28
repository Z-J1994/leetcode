package medium;

import java.util.HashSet;
import java.util.Set;

public class Solution869 {
    private static final Set<String> set = new HashSet<>();

    static{
        set.add("1");// 1
        set.add("2");// 2
        set.add("4");// 4
        set.add("8");// 8
        set.add("16");// 16
        set.add("23");// 32
        set.add("46");// 64
        set.add("128");// 128
        set.add("256");// 256
        set.add("125");// 512
        set.add("0124");// 1024
        set.add("0248");// 2048
        set.add("0469");// 4096
        set.add("1289");// 8192
        set.add("13468");// 16384
        set.add("23678");// 32768
        set.add("35566");// 65536
        set.add("011237");// 131072
        set.add("122446");// 262144
        set.add("224588");// 524288
        set.add("0145678");// 1048576
        set.add("0122579");// 2097152
        set.add("0134449");// 4194304
        set.add("0368888");// 8388068
        set.add("11266777");// 16777216
        set.add("23334455");// 33445532
        set.add("01466788");// 67108864
        set.add("112234778");// 134217728
        set.add("234455668");// 268435456
        set.add("012356789");// 536870912
    }

    public boolean reorderedPowerOf2(int n) {
        int [] numbers = new int[10];
        while(n > 0){
            numbers[n % 10]++;
            n /= 10;
        }
        int index = 0;
        char [] chars = new char[10];
        for(int i = 0;i < 10;i++){
            while(numbers[i] != 0){
                chars[index++] = (char)(i + 48);
                numbers[i]--;
            }
        }
        return set.contains(new String(chars,0,index));
    }
}
