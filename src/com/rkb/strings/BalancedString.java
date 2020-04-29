package com.rkb.strings;

import java.util.Stack;

/**
 * 
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

 

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
 * @author ramkrishnabhattarai
 *
 */

public class BalancedString {
	
	 public int balancedStringSplit(String s) {
	        Stack<Character> stk = new Stack<>();
	        int strLen = s.length();
	        int count = 0;
	        for(int i=0;i<strLen;i++){
	            if(!stk.isEmpty() && stk.peek()!=s.charAt(i)){
	                stk.pop();
	                if(stk.isEmpty()){
	                    count++;  
	                }
	            }
	            else{
	                stk.push(s.charAt(i));
	            }
	        }
	        return count;
	            
	    }

}
