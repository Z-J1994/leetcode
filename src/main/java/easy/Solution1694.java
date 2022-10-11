package easy;

public class Solution1694 {
    public String reformatNumber(String number) {
        char [] chars = new char[number.length() << 1];
        int index = 0;
        int s = 0;
        for(int i = 0,l = number.length();i < l;i++){
            char c = number.charAt(i);
            if(c >= '0'){
                chars[index++] = c;
                if(++s == 3){
                    chars[index++] = '-';
                    s = 0;
                }
            }
        }

        if(s == 0){
            index--;
        }else if(s == 1 && index > 2){
            chars[index - 2] = chars[index - 3];
            chars[index - 3] = '-';
        }
        return new String(chars,0,index);
    }
}
