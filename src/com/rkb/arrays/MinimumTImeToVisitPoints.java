package com.rkb.arrays;


/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.
 

Example 1:


Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5
 

Constraints:

points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000
 * @author ramkrishnabhattarai
 *
 */
public class MinimumTImeToVisitPoints {

	public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        
        for (int i = 0; i < points.length-1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int a = points[i+1][0];
            int b = points[i+1][1];
            
            time += Math.max(Math.abs(a - x), Math.abs(b - y));
        }
        
        return time;
    }
	
	//approach 2
	public static int diff(int x1 ,int x2 , int y1 ,int y2){
	    int a = Math.abs(x2-x1);
	    int b = Math.abs(y2-y1);
	    return a>b?a:b;
	}
	public int minTimeToVisitAllPoints2(int[][] p) {
	    int totalTime = 0;
	    int q=1;
	    int i=0;
	    while (q!=p.length){
	        totalTime+=diff(p[i][0] , p[i+1][0] , p[i][1] , p[i+1][1]);
	        q++;
	        i++;
	    }

	    return totalTime;
	}
}
