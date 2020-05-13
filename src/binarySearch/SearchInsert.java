package binarySearch;
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 * @author ramkrishnabhattarai
 *
 */

public class SearchInsert {

	
	public int searchInsert(int[] nums, int target) {
        int fin=nums.length;
        for( int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }   
        }
        if(target>nums[fin-1]){
            return fin;
        }
        return 0;       
    }
	
	// 2nd approach
	public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
       if (target < nums[mid])
           return mid;
        else 
            return mid + 1;
    }
}
