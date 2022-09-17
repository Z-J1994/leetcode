package medium;

/**
 * @author zhangjun
 * @since 2022/9/13 12:49
 */
public class Solution670 {
    public int maximumSwap(int num) {
        int [] ints = new int[9];
        int index = 0;
        while(num > 0){
            ints[index++] = num % 10;
            num /= 10;
        }
        for(int i = index - 1;i > 0 && !swap(ints,i);i--);
        int result = 0;
        for(int i = index - 1;i >= 0;i--){
            result = result * 10 + ints[i];
        }
        return result;
    }

    private boolean swap(int [] ints,int end){
        int index = end;
        for(int i = end - 1;i >= 0;i--){
            if(ints[i] >= ints[index]){
                index = i;
            }
        }
        if(ints[index] != ints[end]){
            int t = ints[index];
            ints[index] = ints[end];
            ints[end] = t;
            return true;
        }
        return false;
    }
}
