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
	
	//2nd approach
	
	public int countNegatives2(int[][] grid) {
        int n=grid.length-1;
        int m=grid[0].length-1;
        if(grid[n][m]>=0) return 0;
        if(grid[0][0]<0) return (m+1)*(n+1);
        int start=0;
        int ans=0;
        for(int i=n;i>=0;i--){
            if(grid[i][m]>=0) return ans;
            start=getStart(grid[i],start,m);
            ans+=(m-start+1);
        }
        return ans;
    }
    public int getStart(int []arr,int s,int e){
        while(s<e){
            int mid=(s+e)/2;
            if(arr[mid]>=0) s=mid+1;
            else e=mid;
        }
        return s;
    }
    
    //3rd approach
    public int countNegatives3(int[][] grid) {
    	int count = 0;

    	    for(int i = 0;i<grid.length;i++){
    	        int start = 0,end = grid[0].length-1,mid = 0,loc=-1;
    	        
    	        //Binary Search
    	        while(start<=end){
    	            mid = (start+end)/2;
    	            if(grid[i][mid]>=0){
    	                start = mid+1;
    	            }
    	            else{
    	                end = mid-1;
    	                loc = mid;
    	            }
    	        }
    	        
    	        if(loc!=-1)//If there was a negative number
    	        count +=(grid[0].length-loc);
    	    }
    	    
    	    return count;
    	}

}
