package easy;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        //找到从后往前第一个不是9的位
        while(index >= 0 && digits[index] == 9){
            index--;
        }
        //全是9,结果一定为1000....000
        if(index == -1){
            int [] newValue = new int[digits.length + 1];
            newValue[0] = 1;
            digits = newValue;
        }else{
            //将第一个不为9的位 + 1,其右边所有数字全进位变为0
            for(int i = digits.length - 1;i > index;i--){
                digits[i] = 0;
            }
            digits[index]++;
        }
        return digits;
    }
}
