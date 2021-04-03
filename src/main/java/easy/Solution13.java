package easy;

public class Solution13 {
    public int romanToInt(String s) {

        int answer = 0;
        for(int i = s.length() - 1,t = 0,pt = 0;i >= 0;i--){
            switch(s.charAt(i)){
                case 'I': t = 1;break;
                case 'V': t = 5;break;
                case 'X': t = 10;break;
                case 'L': t = 50;break;
                case 'C': t = 100;break;
                case 'D': t = 500;break;
                case 'M': t = 1000;break;
            }
            if(pt > t){
                t = -t;
            }
            answer += t;
            pt = t;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution13 s = new Solution13();

        String str1 = "III";
        String str2 = "IV";
        String str3 = "IX";
        String str4 = "LVIII";
        String str5 = "MCMXCIV";

        System.out.println(s.romanToInt(str1));//3
        System.out.println(s.romanToInt(str2));//4
        System.out.println(s.romanToInt(str3));//9
        System.out.println(s.romanToInt(str4));//58
        System.out.println(s.romanToInt(str5));//1994

    }
}
