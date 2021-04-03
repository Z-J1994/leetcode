package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:58
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
