package DepthFirstSearch;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 * @author ramkrishnabhattarai
 *
 */

public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }
    
    
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor!= newColor){
        image[sr][sc] = newColor;
            if(sr - 1 >= 0 && image[sr - 1][sc] == oldColor){
                floodFill(image, sr-1, sc, newColor);
            }
            if(sc - 1 >= 0 && image[sr][sc- 1] == oldColor){
                floodFill(image, sr, sc-1, newColor);
            }
            if(sr + 1 < image.length && image[sr + 1][sc] == oldColor){
                floodFill(image, sr+1, sc, newColor);
            }
            if(sc + 1 < image[0].length && image[sr][sc+1] == oldColor){
                floodFill(image, sr, sc+1, newColor);
            }
        }
        return image;
    }

}
