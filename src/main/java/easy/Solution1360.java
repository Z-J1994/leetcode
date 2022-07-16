package easy;

/**
 * @author zhangjun
 * @since 2022/7/11 13:05
 */
public class Solution1360 {
    public int daysBetweenDates(String date1, String date2) {
        char [] chars1 = date1.toCharArray();
        char [] chars2 = date2.toCharArray();
        for(int i = 0;i < chars1.length;i++){
            if(chars1[i] > chars2[i]){
                char [] t = chars1;
                chars1 = chars2;
                chars2 = t;
                break;
            }else if(chars1[i] < chars2[i]){
                break;
            }
        }
        int startYear = getNumber(chars1,0,3);
        int startMonth = getNumber(chars1,5,6);
        int startDay = getNumber(chars1,8,9);
        int endYear = getNumber(chars2,0,3);
        int endMonth = getNumber(chars2,5,6);
        int endDay = getNumber(chars2,8,9);

        int count = 0;
        for(int i = startYear;i < endYear;i++){
            if(leapYear(i)){
                count += 366;
            }else{
                count += 365;
            }
        }
        return count - getDays(leapYear(startYear),startMonth,startDay) + getDays(leapYear(endYear),endMonth,endDay);
    }

    private int getNumber(char [] s,int startIndex,int endIndex){
        int r = 0;
        while(startIndex <= endIndex){
            r = r * 10 + (s[startIndex++] - '0');
        }
        return r;
    }

    private boolean leapYear(int year){
        return ((year & 3) == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDays(boolean leap,int month,int day){
        int result = 0;
        switch(month){
            case 12: result += 30;
            case 11: result += 31;
            case 10: result += 30;
            case 9: result += 31;
            case 8: result += 31;
            case 7: result += 30;
            case 6: result += 31;
            case 5: result += 30;
            case 4: result += 31;
            case 3: result += 28;
            case 2: result += 31;
        }
        if(leap && month > 2){
            result++;
        }
        return result + day;
    }

    public static void main(String[] args) {
        Solution1360 s = new Solution1360();
//        System.out.println(s.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(s.daysBetweenDates("2074-09-08","2074-09-12"));
    }
}
