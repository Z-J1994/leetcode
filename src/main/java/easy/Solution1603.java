package easy;

/**
 * @author zhangjun
 * @date 2021/3/19
 */
public class Solution1603 {

    class ParkingSystem {

        private int small;
        private int medium;
        private int big;

        public ParkingSystem(int big, int medium, int small) {
            this.small = small;
            this.medium = medium;
            this.big = big;
        }

        public boolean addCar(int carType) {
            switch(carType){
                case 3:return small-- > 0;
                case 2:return medium-- > 0;
                case 1:return big-- > 0;
            }
            return false;
        }
    }
}
