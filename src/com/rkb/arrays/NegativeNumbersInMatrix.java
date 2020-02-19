package com.rkb.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NegativeNumbersInMatrix {

	/**
	 * 
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
	 */
	public static void main(String[] args) {
		NegativeNumbersInMatrix negativeNumbersInMatrix = new NegativeNumbersInMatrix();

	}
	
	
	
	
	public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0; i< grid.length; i++) {
			count += count(grid[i]);
		}
        return count;
    }
	
	public int count(int[] nums) {
		int count = 0;
		for(int i=0; i< nums.length; i++) {
			if(nums[i] < 0) count++;
		}
		return count;
	}

}
