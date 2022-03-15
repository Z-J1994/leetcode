package medium;

public class Solution393 {
    public boolean validUtf8(int[] data) {
        int target = 2 << 6;
        int mask = 3 << 6;
        for(int i = 0,l;i < data.length;i++){
            for(l = 7;l > 3 && ((1 << l) & data[i]) != 0;l--);
            if(l == 6 || ((1 << l) & data[i]) != 0){
                return false;
            }
            while(++l < 7){
                if(++i >= data.length || (data[i] & mask) != target){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution393 s = new Solution393();
//        System.out.println(s.validUtf8(new int[]{197, 130, 1}));
        System.out.println(Integer.toBinaryString(145));
        System.out.println(s.validUtf8(new int[]{145}));
    }
}
