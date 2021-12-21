package easy;

/**
 * @author zhangjun
 * @version 2021/12/21
 */
public class Solution1154 {
    public int dayOfYear(String date) {
        int year = 0;
        for (int i = 0;i < 4;i++){
            year = year * 10 + (date.charAt(i) - '0');
        }
        int month = date.charAt(5) - '0';
        month = month * 10 + date.charAt(6) - '0';
        int day = date.charAt(8) - '0';
        day = day * 10 + date.charAt(9) - '0';

        int t = 0;
        if(((year & 3) == 0 && (year % 100) != 0) || (year % 400) == 0){
            t = 1;
        }
        int answer = 0;
        switch(month){
            case 12: answer += 30;
            case 11: answer += 31;
            case 10: answer += 30;
            case 9: answer += 31;
            case 8: answer += 31;
            case 7: answer += 30;
            case 6: answer += 31;
            case 5: answer += 30;
            case 4: answer += 31;
            case 3: answer += (28 + t);
            case 2: answer += 31;
        }
        answer += day;
        return answer;
    }
}
