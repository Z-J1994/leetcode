package easy;

/**
 * @author zhangjun
 * @version 2020/10/09  23:10
 */
public class Interview05_03 {
    public int reverseBits(int num) {
        if(num == 0){
            return 1;
        }
        byte [] map = new byte[32];
        int i = 0;
        boolean marked = true;
        while(num != 0){
            if((num & 0x1) == 1){
                if(!marked){
                    ++i;
                }
                map[i]++;
                marked = true;
            }else {
                if(marked){
                    ++i;
                }
                map[i]--;
                marked = false;
            }
            num >>>= 1;
        }

        for(int t = 0;t <= i;t++){
            if(map[t] == -1 && t < i){
                int x = map[t - 1] + map[t + 1] + 1;
                if(x > num){
                    num = x;
                }
            }else if(map[t] + 1 > num){
                num = map[t] + 1;
            }
        }

        return num == 33 ? 32 : num;
    }
}
