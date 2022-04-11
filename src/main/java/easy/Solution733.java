package easy;

/**
 * @author zhangjun
 * @version 2022/3/22
 */
public class Solution733 {
    private final int [][] directions= {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(newColor == oldColor){
            return image;
        }
        image[sr][sc] = newColor;
        dfs(image,sr,sc,oldColor,newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc,int oldColor, int newColor){
        int x,y;
        for(int [] direction:directions){
            if((x = direction[0] + sr) >= 0 && x < image.length && (y = direction[1] + sc) >= 0 && y < image[0].length && image[x][y] == oldColor){
                image[x][y] = newColor;
                dfs(image,x,y,oldColor,newColor);
            }
        }
    }
}
