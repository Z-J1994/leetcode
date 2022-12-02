package medium;

public class Solution1769 {
    public int[] minOperations(String boxes) {
        int [] result = new int[boxes.length()];
        int leftCount = 0,leftSum = 0,rightCount = 0,rightSum = 0;
        for(int i = 0,l = boxes.length();i < l;i++){
            if(boxes.charAt(i) == '1'){
                rightCount++;
                rightSum += i;
            }
        }

        for(int i = 0,l = boxes.length();i < l;i++){
            result[i] = leftSum + rightSum;
            if(boxes.charAt(i) == '1'){
                rightCount--;
                leftCount++;
            }
            rightSum -= rightCount;
            leftSum += leftCount;
        }
        return result;
    }
}
