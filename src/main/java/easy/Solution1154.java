package easy;

/**
 * @author zhangjun
 * @version 2021/12/21
 */
public class Solution1154 {
    public int dayOfYear(String date) {
        char [] d = date.toCharArray();
        int year = getInt(d,0,4);
        int month = getInt(d,5,7);
        int days = getInt(d,8,10);
        switch(month){
            case 12: days += 30;
            case 11: days += 31;
            case 10: days += 30;
            case 9: days += 31;
            case 8: days += 31;
            case 7: days += 30;
            case 6: days += 31;
            case 5: days += 30;
            case 4: days += 31;
            case 3: days += ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
            case 2: days += 31;
        }
        return days;
    }

    public int getInt(char [] date,int start,int end){
        int i = 0;
        while(start < end){
            i = i * 10 + (date[start] - '0');
            start++;
        }
        return i;
    }
}
