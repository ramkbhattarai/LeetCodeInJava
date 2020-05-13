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
    
    
    // 2nd approach
    public int countNegatives2(int[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; ++i){
        
          int index = getIndex(grid[i], 0, grid[i].length-1);
          
          count += (grid[i].length - index);
        }
       return count;
      }
    
    
    // binary search
    
    private int getIndex(int[]array, int s, int e){

      if(s > e)
        return array.length;
      
      int mid = (s+e) >> 1;    
      
      if(array[mid] < 0){
        
        if(mid == 0){
          return 0;  
        }else if(array[mid-1] >= 0)
          return mid;  
        
        return getIndex(array, s, mid);
      }else{
        
        if(mid == array.length-1)
          return array.length;
        else if(array[mid+1] < 0)
          return mid+1;
        
        return getIndex(array, mid+1, e);
      }
    }
}
