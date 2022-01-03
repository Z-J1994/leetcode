package easy;

/**
 * @author zhangjun
 * @version 2022/1/3
 */
public class Solution1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        int sum = 0;
        for(int i = 1970;i < year;i++){
            if(((i & 3) == 0 && (i % 100) != 0) || i % 400 == 0){
                sum += 366;
            }else{
                sum += 365;
            }
        }
        switch(month){
            case 12: sum += 30;
            case 11: sum += 31;
            case 10: sum += 30;
            case 9: sum += 31;
            case 8: sum += 31;
            case 7: sum += 30;
            case 6: sum += 31;
            case 5: sum += 30;
            case 4: sum += 31;
            case 3:
                if(((year & 3) == 0 && (year % 100) != 0) || year % 400 == 0){
                    sum += 29;
                }else{
                    sum += 28;
                }
            case 2: sum += 31;
        }
        sum += day;
        sum %= 7;
        switch(sum){
            case 1: return "Thursday";
            case 2: return "Friday";
            case 3: return "Saturday";
            case 4: return "Sunday";
            case 5: return "Monday";
            case 6: return "Tuesday";
            default: return "Wednesday";
        }
    }
}
