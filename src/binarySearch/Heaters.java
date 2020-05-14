package binarySearch;

import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:

Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
 

Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 

Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 * @author ramkrishnabhattarai
 *
 */
public class Heaters {
	
	public int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int[] mins = new int[houses.length];
		for(int i=0;i<houses.length;i++) {
			mins[i] = binSearchClosest(houses[i],heaters,0,heaters.length);
		}
		int maxMin = 0;
		for(int min: mins) {
			maxMin = Math.max(maxMin, min);
		}
		return maxMin;
	}
		
	public int binSearchClosest(int housePos, int[] heaters, int start, int end) {
		
		while(start<=end) {
			int middle = (start+end)/2;
			int currHeaterPos = heaters[middle];
			if(housePos==currHeaterPos) return 0;
			else if(currHeaterPos<housePos) {
				if(middle+1>=heaters.length) return Math.abs(currHeaterPos-housePos);
				int currHeaterPosPlusOne = heaters[middle+1];
				if(currHeaterPosPlusOne>=housePos) {
					return Math.min(Math.abs(currHeaterPos-housePos), Math.abs(currHeaterPosPlusOne-housePos));
				} else {
					start = middle+1;
				}
			} else { //currHeaterPos>housePos
				if(middle-1<0) return Math.abs(currHeaterPos-housePos);
				int currHeaterPosMinusOne = heaters[middle-1];
				if(currHeaterPosMinusOne<=housePos) {
					return Math.min(Math.abs(currHeaterPos-housePos), Math.abs(currHeaterPosMinusOne-housePos));
				} else {
					end=middle-1;
				}
			}
		}
		
		return 0;
	}

}
