package easy;

public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        int [] alphabet = new int[26];
        int [] indexes = {'b' - 97,'a' - 97,'l' - 97,'o' - 97,'n' - 97};
        //统计全部字符,随机分支过多cpu预测正确率低
        for(int i = 0;i < text.length();i++){
            alphabet[text.charAt(i) - 97]++;
        }
        alphabet['l' - 97] /= 2;
        alphabet['o' - 97] /= 2;
        int min = 0x7fffffff;
        for(int i : indexes){
            if(min > alphabet[i]){
                min = alphabet[i];
            }
        }
        return min;
    }
}
