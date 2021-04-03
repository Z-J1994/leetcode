package easy;

/**
 * @author zhangjun
 * @version 2020/10/03  19:29
 */
public class Interview01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if(length1 != length2){
            return false;
        }
        //假定字符串中只有英文字母。
        byte [] map1 = new byte[123];
        byte [] map2 = new byte[123];
        for(int i = 0;i < length1;i++){
            map1[s1.charAt(i)]++;
            map2[s2.charAt(i)]++;
        }

        for(int i = 0;i < 123;i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }

}
