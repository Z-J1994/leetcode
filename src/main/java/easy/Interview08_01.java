package easy;

/**
 * @author zhangjun
 * @version 2020/12/21  18:13
 */
public class Interview08_01 {
    public int waysToStep(int n) {
        if(n <= 2){
            return n;
        }
        long a = 1,b = 1,c = 2,d = 0;
        for(int i = 3;i <= n;i++){
            d = (a + b + c) % 1000000007;
            a = b;
            b = c;
            c = d;
        }
        return (int)(d);
    }

    public static void main(String[] args) {
        Interview08_01 i = new Interview08_01();
        System.out.println(i.waysToStep(2));
        System.out.println(i.waysToStep(3));
        System.out.println(i.waysToStep(5));
        System.out.println(i.waysToStep(76));
        System.out.println(i.waysToStep(1000000));
    }
}
