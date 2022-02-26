package easy;

/**
 * @author zhangjun
 * @version 2022/2/26
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        char a,b;
        for(int i = 0,j = s.length() - 1;i < j;){
            a = s.charAt(i);
            if(!Character.isLetter(a) && !Character.isDigit(a)){
                i++;
                continue;
            }
            b = s.charAt(j);
            if(!Character.isLetter(b) && !Character.isDigit(b)){
                j--;
                continue;
            }
            if(notEquals(a,b)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
    private boolean notEquals(char a,char b){
        return !(a == b || ((Math.abs(a - b) == 32) && a >= 'A' && b >= 'A'));
    }
    public static void main(String[] args) {
        Solution125 s = new Solution125();
//        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(s.isPalindrome("race a car"));
        System.out.println(s.isPalindrome("0P"));
    }
}
