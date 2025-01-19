package medium;

public class Solution2266 {

    private static final int [] LIMIT = {0,0,3,3,3,3,3,4,3,4};

    private static final int [] DEFAULT = {1,2,4,8};

    public int countTexts(String pressedKeys) {
        long count = 1;
        int p = pressedKeys.charAt(0) - '0';
        long [] previous = {1,0,0,0};
        for(int i = 1,length = pressedKeys.length(),c = 0;i < length;){
            long t = 1;
            for(int l = 1;i < length && (p == (c = pressedKeys.charAt(i++) - '0'));l++){
                t = calculate(c,previous,l);
            }
            if(count == 1){
                count = t;
            }else{
                count *= t;
                count %= 1000000007;
            }
            previous[0] = 1;
            p = c;
        }
        return (int) count;
    }

    private long calculate(int number,long[] previous,int length){
        if(length < LIMIT[number]){
            previous[length] = DEFAULT[length];
            return DEFAULT[length];
        }
        long count = 0;
        for(int i = length - 1,l = length - LIMIT[number];i >= 0 && i >= l;--i){
            count += previous[i & 3];
        }
        count %= 1000000007;
        previous[length & 3] = count;
        return count;
    }

    public static void main(String[] args) {
        Solution2266  s = new Solution2266();
        System.out.println(s.countTexts("2") == 1);
        System.out.println(s.countTexts("22") == 2);
        System.out.println(s.countTexts("222") == 4);
        System.out.println(s.countTexts("2222") == 7);
        System.out.println(s.countTexts("22222") == 13);
        System.out.println(s.countTexts("22233") == 8);
        System.out.println(s.countTexts("44447") == 7);
        System.out.println(s.countTexts("444479") == 7);
        System.out.println(s.countTexts("4444799") == 14);
        System.out.println(s.countTexts("44447999") == 28);
        System.out.println(s.countTexts("444479999") == 56);
        System.out.println(s.countTexts("4444799995") == 56);
        System.out.println(s.countTexts("44447999955") == 112);
        System.out.println(s.countTexts("444479999555") == 224);
        System.out.println(s.countTexts("4444799995555") == 392);
//        System.out.println(s.countTexts("44447999955558") == 3136);
//        System.out.println(s.countTexts("444479999555588") == 3136);
//        System.out.println(s.countTexts("44447999955558886") == 3136);
//        System.out.println(s.countTexts("444479999555588866") == 3136);
    }
}
