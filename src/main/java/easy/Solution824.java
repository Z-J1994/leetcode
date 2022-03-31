package easy;

public class Solution824 {
    public String toGoatLatin(String sentence) {
        int length = sentence.length();
        char [] value = new char[length + (1 + length) * length / 2];
        int index = 0;
        char c;
        char f = 0;
        char p = ' ';
        int count = 0;
        for(int i = 0;i < length;i++){
            c = sentence.charAt(i);
            if(p == ' '){
                f = c;
                switch (f){
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':value[index++] = f;break;
                    default:
                }
            }else if(c == ' '){
                switch (f){
                    default: value[index++] = f;
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':value[index++] = 'm';value[index++] = 'a';
                }
                ++count;
                for(int j = 0;j < count;j++){
                    value[index++] = 'a';
                }
                value[index++] = ' ';
            }else{
                value[index++] = c;
            }
            p = c;
        }
        switch (f){
            default: value[index++] = f;
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':value[index++] = 'm';value[index++] = 'a';
        }
        for(int j = 0;j <= count;j++){
            value[index++] = 'a';
        }
        return new String(value,0,index);
    }

    public static void main(String[] args) {
        Solution824 s = new Solution824();
//        System.out.println(s.toGoatLatin("I speak Goat Latin"));
        System.out.println(s.toGoatLatin("G UxjR"));
    }
}
