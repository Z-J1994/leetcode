package easy;

/**
 * @author zhangjun
 * @version 2020/10/03  19:29
 */
public class Interview01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int [] alphabet = new int[128];
        for(int i = 0,length = s1.length();i < length;i++){
            alphabet[s1.charAt(i)]++;
        }
        for(int i = 0,length = s2.length();i < length;i++){
            if(--alphabet[s2.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
}
