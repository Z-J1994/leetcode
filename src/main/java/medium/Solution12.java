package medium;

public class Solution12 {

    public String intToRoman(int num) {
        //如果要增加范围，只需把字母添加到table数组的两个空字符后面，并且重新计算i的初始值i = 10 ^ (table.length / 3);
        char [] table = {' ',' ','M','D','C','L','X','V','I'};
        char [] values = new char[16];
        int index = 0;

        for(int i = 1000,j = 2;i > 0;i /= 10,j += 2){
            index = aid(num / i,values,index,table[j],table[j - 1],table[j - 2]);
            num %= i;

        }

        return new String(values,0,index);
    }

    private int aid(int n,char [] values,int index,char str1,char str2,char str3){

        switch(n){
            case 9:values[index++] = str1;values[index++] = str3;break;
            case 8:values[index++] = str2;values[index++] = str1;values[index++] = str1;values[index++] = str1;break;
            case 7:values[index++] = str2;values[index++] = str1;values[index++] = str1;break;
            case 6:values[index++] = str2;values[index++] = str1;break;
            case 5:values[index++] = str2;break;
            case 4:values[index++] = str1;values[index++] = str2;break;
            case 3:values[index++] = str1;values[index++] = str1;values[index++] = str1;break;
            case 2:values[index++] = str1;values[index++] = str1;break;
            case 1:values[index++] = str1;break;
        }

        return index;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        int n1 = 3;
        int n2 = 4;
        int n3 = 9;
        int n4 = 58;
        int n5 = 1994;
        int n6 = 10;
        int n7 = 388;

        System.out.println(s.intToRoman(n1));//III
        System.out.println(s.intToRoman(n2));//IV
        System.out.println(s.intToRoman(n3));//IX
        System.out.println(s.intToRoman(n4));//LVIII
        System.out.println(s.intToRoman(n5));//MCMXCIV
        System.out.println(s.intToRoman(n6));//X
        System.out.println(s.intToRoman(n7));//X
    }
}
