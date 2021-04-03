package easy;

import java.util.Arrays;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int length = A.length;
        Boolean [] result = new Boolean[length];

        for(int i = 0;i < length;i++){
            result[i] = false;
        }

        for(int i = 0,t = 0;i < length;i++){
            t = ((t << 1) + A[i]) % 5;

            if(t == 0){
                result [i] = true;
            }
        }
        return Arrays.asList(result);
    }
}
