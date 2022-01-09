package easy;

public class Solution1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int p = 0;
        int max = 0;
        char c;
        for(int i = 0,t;i < releaseTimes.length;i++){
            if((t = releaseTimes[i] - p) > max){
                max = t;
                result = keysPressed.charAt(i);
            }else if(t == max && (c = keysPressed.charAt(i)) > result){
                result = c;
            }
            p = releaseTimes[i];
        }
        return result;
    }
}
