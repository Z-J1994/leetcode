package medium;

import java.util.Arrays;

public class Solution556 {
    public int nextGreaterElement(int n) {
        int[] element = new int[12];
        element[0] = 10;
        int offset = 12;
        int origin = n;
        while (n > 0) {
            element[--offset] = n % 10;
            n /= 10;
        }
        for (int targetIndex, i = 10; i >= offset; i--) {
            targetIndex = 0;
            for (int j = i + 1; j < 12; j++) {
                if (element[j] > element[i] && element[j] < element[targetIndex]) {
                    targetIndex = j;
                }
            }
            if (targetIndex != 0) {
                int temp = element[i];
                element[i] = element[targetIndex];
                element[targetIndex] = temp;
                Arrays.sort(element, i + 1, 12);
                break;
            }
        }
        long number = 0;
        for(int i = offset;i < 12;i++){
            number = number * 10 + element[i];
        }
        if(number <= origin || number > 0x7fffffff){
            return -1;
        }
        return (int) number;
    }
}
