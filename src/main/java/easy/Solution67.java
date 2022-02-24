package easy;

/**
 * @author zhangjun
 * @version 2022/2/24
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        char [] answer = new char[Math.max(a.length(),b.length()) + 1];
        int index = answer.length;
        int o1 = 0,o2 = 0,c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 && j >= 0){
            o1 = 0;
            o2 = 0;
            if(a.charAt(i--) == '1'){
                o1 = 1;
            }
            if(b.charAt(j--) == '1'){
                o2 = 1;
            }
            answer[--index] = (char)(o1 + o2 + c + 48);
            c = 0;
            if(answer[index] > '1'){
                answer[index] -= 2;
                c = 1;
            }
        }
        while(i >= 0){
            o1 = 0;
            if(a.charAt(i--) == '1'){
                o1 = 1;
            }
            answer[--index] = (char)(o1 + c + 48);
            c = 0;
            if(answer[index] > '1'){
                answer[index] -= 2;
                c = 1;
            }
        }
        while(j >= 0){
            o2 = 0;
            if(b.charAt(j--) == '1'){
                o2 = 1;
            }
            answer[--index] = (char)(o2 + c + 48);
            c = 0;
            if(answer[index] > '1'){
                answer[index] -= 2;
                c = 1;
            }
        }
        if(c != 0){
            answer[--index] = (char) (c + 48);
        }
        return new String (answer,index,answer.length - index);
    }
    public static void main(String[] args) {
        Solution67 s = new Solution67();
//        System.out.println(s.addBinary("11", "1"));
//        System.out.println(s.addBinary("1010", "1011"));
        System.out.println(s.addBinary("101111","10"));
    }
}
