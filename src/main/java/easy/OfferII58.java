package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  9:34
 */
public class OfferII58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}
