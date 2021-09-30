package medium;

/**
 * @author zhangjun
 * @version 2021/9/30
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x = 0;
        if(bx1 >= ax1 && bx1 <= ax2){
            if(bx2 >= ax1 && bx2 <= ax2){
                x = bx2 - bx1;
            }else{
                x = ax2 - bx1;
            }
        }else if(bx2 >= ax1 && bx2 <= ax2){
            x = bx2 - ax1;
        }else if (bx1 <= ax1 && bx2 >= ax2){
            x = ax2 - ax1;
        }

        int y = 0;

        if(by1 >= ay1 && by1 <= ay2){
            if(by2 >= ay1 && by2 <= ay2){
                y = by2 - by1;
            }else{
                y = ay2 - by1;
            }
        }else if(by2 >= ay1 && by2 <= ay2){
            y = by2 - ay1;
        }else if(by1 <= ay1 && by2 >= ay2){
            y = ay2 - ay1;
        }

        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int aeraB = (bx2 - bx1) * (by2 - by1);

        return (areaA + aeraB) - (x * y);
    }
}
