package easy;

public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length - 1;
        if(length == 0 || bits[length - 1] == 0){
            return true;
        }
        int index = 0;
        while(index < length){
            index += bits[index] + 1;
        }
        return index == length;
    }
}
