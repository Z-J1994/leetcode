package medium;

public class Solution11 {
    public int maxArea(int[] height) {
        int area = 0;
        for(int i = 0,j = height.length - 1,left = height[i],right = height[j],wide,h;i < j;){
            wide = j - i;
            h = left;
            if(left > right){
                h = right;
                j--;
                right = height[j];
            }else if(left < right){
                i++;
                left = height[i];
            }else{
                i++;
                j--;
                left = height[i];
                right = height[j];
            }
            int newArea = wide * h;
            if(newArea > area){
                area = newArea;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution11 s = new Solution11();

        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        int[] height3 = {4,3,2,1,4};
        int[] height4 = {1,2,1};

        System.out.println(s.maxArea(height1));//49
        System.out.println(s.maxArea(height2));//1
        System.out.println(s.maxArea(height3));//16
        System.out.println(s.maxArea(height4));//2

    }
}
