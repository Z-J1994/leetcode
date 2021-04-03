package easy;

/**
 * @author zhangjun
 * @version 2021/1/17/ 10:07
 */
public class Solution1232 {

//    常规求斜率
//    public boolean checkStraightLine(int[][] coordinates) {
//        int x = coordinates[0][0];
//        int y = coordinates[0][1];
//        double k = 1.0 * (coordinates[1][1] - y) / (coordinates[1][0] - x );
//
//        for(int i = 2,l = coordinates.length;i < l;i++){
//            double t = 1.0 * (coordinates[i][1] - y) / (coordinates[i][0] - x );
//            if(t != k){
//                if((t  == Double.POSITIVE_INFINITY || t == Double.NEGATIVE_INFINITY) && (k == Double.NEGATIVE_INFINITY || k  == Double.POSITIVE_INFINITY)){
//                    continue;
//                }
//                return false;
//            }
//        }
//        return true;
//    }

//    将求斜率的除法转换为乘法提升速度
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0];
        int y = coordinates[0][1];

        int x1 = coordinates[1][0] - x;
        int y1 = coordinates[1][1] - y;

        for(int i = 2,l = coordinates.length;i < l;i++){
            if(y1 * (coordinates[i][0] - x) != x1 * (coordinates[i][1] - y)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution1232 s = new Solution1232();
        int [][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(s.checkStraightLine(coordinates));
    }
}
