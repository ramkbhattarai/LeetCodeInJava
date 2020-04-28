package com.rkb.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, 
 * are there elements a, b, c, and d in nums such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author ramkrishnabhattarai
 *
 */

public class FourSum {


	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if(nums == null || nums.length == 0) {
	            return result;
	        }
	        
	        /*
	         * This derives lot of optimization decisions (ensuring next numbers will be >= current)
	         */
	        Arrays.sort(nums);
	        
	        for(int i = 0; i <= nums.length-4; i++) {
	        	
	        	/*
	        	 * If current and previous values at ith index are same, then continue to avoid duplicate
	        	 */
	            if(i > 0 && nums[i] == nums[i-1]) {
	                continue;
	            }
	            
	            /*
	             * Over flow checks
	             * If 4 times value at i is greater than target .. then we can break it, in-fact we can directly return from here
	             */
	            if(4*nums[i] > target) {
	            	return result;
	            } else if (4*nums[i] == target && i+3 < nums.length && nums[i] == nums[i+3]) {
	            	
	            	/*
	            	 * If 4*values is same then ensure i+3 is same as well and if thats so, add to result and return back.
	            	 */
	                result.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
	                return result;
	            }
	            
	            for(int j = i+1; j <= nums.length-3; j++) {
	            	
	            	/*
	            	 * Same over flow checks can be added here as well to further improve time
	            	 */
	                if(j > i+1 && nums[j] == nums[j-1]) {
	                    continue;
	                }
	                
	                int low = j+1;
	                int high = nums.length-1;
	                
	                while(low < high) {
	                	
	                	/*
	                	 * Same over flow checks can be added here as well for low and high to further improve time
	                	 */
	                    if(low > j+1 && nums[low] == nums[low-1]) {
	                        low++;
	                        continue;
	                    } else if (high < nums.length-1 && nums[high] == nums[high+1]) {
	                        high--;
	                        continue;
	                    }
	                    
	                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
	                    
	                    if(sum == target) {
	                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high])); 
	                        high--;
	                        low++;
	                    } else if (sum > target) {
	                        high--;
	                    } else {
	                        low++;
	                    }
	                }
	            }
	        }
	        return result;
	    }

}
