package medium;

/**
 * @author zhangjun
 * @date 2021/3/12
 */
public class Solution331 {
    private int index;
    private int maxIndex;
    public boolean isValidSerialization(String preorder) {
        index = 0;
        maxIndex = preorder.length() - 1;
        boolean result = dfs(preorder);
        if(index != maxIndex){
            return false;
        }
        return result;
    }

    private boolean dfs(String preorder){
        if(index > maxIndex){
            return false;
        }
        if(preorder.charAt(index) == '#'){
            return true;
        }
        index += 2;
        char c;
        while(index < maxIndex && (c = preorder.charAt(index + 1)) >= '0' && c <= '9'){
            index++;
        }
        boolean b1 = dfs(preorder);

        index += 2;
        while(index < maxIndex && (c = preorder.charAt(index + 1)) >= '0' && c <= '9'){
            index++;
        }
        return b1 && dfs(preorder);
    }

    public static void main(String[] args) {
        Solution331 s = new Solution331();
        String preorder1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String preorder2 = "1,#";
        String preorder3 = "1,#,#,1";
        String preorder4 = "9,#,92,#,#";

        System.out.println(s.isValidSerialization(preorder1) == true);
        System.out.println(s.isValidSerialization(preorder2) == false);
        System.out.println(s.isValidSerialization(preorder3) == false);
        System.out.println(s.isValidSerialization(preorder4) == true);
    }
}
