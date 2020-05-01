package com.rkb.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
 * @author ramkrishnabhattarai
 *
 */
public class LuckyNumber {
	
	// approach1v
	
	 public List<Integer> luckyNumbers (int[][] matrix) {
	        //O(k) space, where k = number of happy numebrs 
	        List<Integer> l = new ArrayList<Integer>();
	        int col = 0;
	        //O(number of rows) time 
	        for(int i = 0; i < matrix.length; ++i){
	            int min = Integer.MAX_VALUE;
	            //finding the min element in the row
	            //O(number of elements in row) time
	            for(int j = 0; j < matrix[i].length; ++j){
	                if(matrix[i][j] < min){
	                    min = matrix[i][j];
	                    col = j;
	                }
	            }
	            int flag = 1;
	            int k;
	            //checking wether any element greated than our min element in column wise
	            //O(number of elements in column) time
	            for(k = 0; k < matrix.length; ++k){
	                if(matrix[k][col] > min){
	                    flag = 0;
	                    break;
	                }
	            }
	            //if nothing is greater, then we'll add that to our list
	            if(flag == 1){
	                l.add(matrix[i][col]);
	            }
	        }
	        //total time will be (row *(row + column))
	        return l;
	    }
	 
	 

}
