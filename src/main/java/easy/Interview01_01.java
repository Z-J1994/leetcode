package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  18:56
 */
public class Interview01_01 {
    public boolean isUnique(String astr) {
        long bitmap = 0;
        for(int i = 0,l = astr.length();i < l;i++){
            char c = astr.charAt(i);
            long mask = 1;
            if(c >= 97){
                mask <<= (c - 71);
            }else{
                mask <<= (c - 65);
            }
            if((bitmap & mask) != 0){
                return false;
            }
            bitmap |= mask;
        }
        return true;
    }
}
