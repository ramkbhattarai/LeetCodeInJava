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
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 * @author ramkrishnabhattarai
 *
 */
public class CountNegatives {

	public int countNegatives(int[][] grid) {        
        int count = 0;
        int len = grid[0].length;

        for (int[] a : grid){
            int result = binarySearch(a);
            if (result != -1){
                count += (len - result);
            }
        }

        return count;
    }
    
    private int binarySearch(int[] array){

        int low = 0, high = array.length - 1, mid;

        while (low <= high){
            mid = low + (high - low) / 2;
            int number = array[mid];

            if (number < 0){
                if (mid - 1 < 0){
                    return mid;
                } else {
                    if (array[mid - 1] >= 0){
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                }
            } else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
