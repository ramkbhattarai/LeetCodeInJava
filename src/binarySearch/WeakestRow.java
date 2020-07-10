package binarySearch;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.

 

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 2 
row 1 -> 4 
row 2 -> 1 
row 3 -> 2 
row 4 -> 5 
Rows ordered from the weakest to the strongest are [2,0,3,1,4]
Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers for each row is: 
row 0 -> 1 
row 1 -> 4 
row 2 -> 1 
row 3 -> 1 
Rows ordered from the weakest to the strongest are [0,2,3,1]
 * @author ramkrishnabhattarai
 *
 */

public class WeakestRow {
	
	 public int[] kWeakestRows1(int[][] mat, int k) {
	        int i,j,count;
	        int[] arr=new int[mat.length];
	        for(i=0;i<mat.length;i++){
	            count=0;
	            for(j=0;j<mat[i].length;j++)
	            {
	                if(mat[i][j]==1) count++;
	                    else break;
	            }
	            arr[i]=count;
	        }
	        int min,index=0;
	        int []ans=new int[k];
	        for(i=0;i<k;i++){
	            min=2147483647;
	            index=0;
	            for(j=0;j<arr.length;j++){
	                if(arr[j]<min){
	                    min=arr[j];
	                    index=j;
	                }
	            }
	            ans[i]=index;
	            arr[index]=2147483647;
	        }
	       return ans;
	    }

}
