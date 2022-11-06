package easy;

public class Solution1678 {
    public String interpret(String command) {
        char [] chars = new char[command.length() << 1];
        int length = 0;
        for(int i = 0,l = command.length();i < l;i++){
            if(command.charAt(i) == 'G'){
                chars[length++] = 'G';
            }else if(command.charAt(i + 1) == ')'){
                chars[length++] = 'o';
                i++;
            }else {
                chars[length++] = 'a';
                chars[length++] = 'l';
                i += 3;
            }
        }
        return new String(chars,0,length);
    }
}
