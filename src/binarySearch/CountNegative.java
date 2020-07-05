package binarySearch;
/**
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.
Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 * @author ramkrishnabhattarai
 *
 */

public class CountNegative {
	
	public int countNegatives(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int res = 0;
        int mid;
        int left;
        int right;
        for(int i = 0, length = grid.length; i < length; i++){
            int[] tempArr = grid[i];
            if(tempArr[0] < 0){
                res += tempArr.length;
                continue;
            }
            left = 0;
            right = tempArr.length;
            while(left < right){
                mid = left + ((right - left) >> 1);
                if(tempArr[mid] >= 0){
                    left = mid + 1;
                } else{
                    if(mid > 0 && tempArr[mid - 1] >= 0){
                        res += tempArr.length - mid;
                        break;
                    }
                    right = mid;
                }
            }
        }
        return res;
    }

}
