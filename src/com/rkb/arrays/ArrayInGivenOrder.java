package com.rkb.arrays;


/**
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

 

Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
Example 2:

Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
Example 3:

Input: nums = [1], index = [0]
Output: [1]
 

Constraints:

1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i
 * @author ramkrishnabhattarai
 *
 */
public class ArrayInGivenOrder {
	
	public static int[] createTargetArray(int[] nums, int[] index) {
		int n = nums.length;
		int[] target = new int[n];

		// this array will be storing the indexes for final target array
		int[] targetIndex = new int[n];
		for (int i = 0; i < n; i++) {
			// position at which new element will be inserted
			int pos = index[i];

			// array elements by default will be 0; hence (i+1) is inserted
			if (targetIndex[pos] == 0) {
				targetIndex[pos] = i + 1;
			} else {
				int old = targetIndex[pos];
				targetIndex[pos] = i + 1;

				// at any given time, for ith run of loop there will be (i+1) element in
				// targetIndex array
				for (int j = pos + 1; j < i + 1; j++) {
					int temp = targetIndex[j];
					targetIndex[j] = old;
					old = temp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			target[i] = nums[targetIndex[i] - 1];
		}

		return target;
	}

}
