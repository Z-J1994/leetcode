package medium;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        switch(n){
            case 8: result += 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3;
            case 7: result += 9 * 9 * 8 * 7 * 6 * 5 * 4;
            case 6: result += 9 * 9 * 8 * 7 * 6 * 5;
            case 5: result += 9 * 9 * 8 * 7 * 6;
            case 4: result += 9 * 9 * 8 * 7;
            case 3: result += 9 * 9 * 8;
            case 2: result += 9 * 9;
            case 1: result += 9;
            case 0: result += 1;
        }
        return result;
    }
}
