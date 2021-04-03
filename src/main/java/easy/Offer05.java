package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  23:25
 */
public class Offer05 {
//    public String replaceSpace(String s) {
//        return s.replace(" ","%20");
//    }
    public String replaceSpace(String s){
        int count = 0;
        int length = s.length();
        for(int i = 0;i < length;i++){
            char c = s.charAt(i);
            if(c == ' '){
                count++;
            }
        }
        char []chars = new char[length + count * 2];
        int r = chars.length - 1;
        for(int i = length - 1;i >= 0;i--){
            char c = s.charAt(i);
            if(c == ' '){
                chars[r--] = '0';
                chars[r--] = '2';
                chars[r--] = '%';
            }else{
                chars[r--] = c;
            }
        }
        return new String(chars);
    }
}
