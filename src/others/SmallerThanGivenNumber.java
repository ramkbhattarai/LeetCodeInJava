package others;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 * @author ramkrishnabhattarai
 *
 */

public class SmallerThanGivenNumber {
	
	public int[] method1(int[] nums){
		int[] a = new int[101];
        int[] b = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            b[i]=nums[i];
        }
        Arrays.sort(b);
        int t=0;
        int temp=0;
        for(int i=0;i<b.length;i++){
            if(a[b[i]]!=0){
                t++;
                continue;
            }
            if(b[i]==temp){
                t++;
                continue;
            }
            a[b[i]]=t;
            temp = b[i];
            t++;
        }
        for(int k=0;k<nums.length;k++){
            int abc = nums[k];
            nums[k]=a[abc];
        }
        return nums;
		
	}
	
	 public int[] smallerNumbersThanCurrent(int[] nums) {
	        int len = nums.length;
	        int[] result = new int[len];
	        List<Integer> temp = new ArrayList<>();

	        for(int n : nums) temp.add(n);

	        Collections.sort(temp);

	        for (int i = 0 ; i < len ; i++) {
	            result[i] = temp.indexOf(nums[i]);
	        }

	        return result;
	    }
	 
	 
	 public int[] smallerNumbersThanCurrent(int[] nums) {
	        int[] buck = new int[101];
	        
	        for(int i=0; i<nums.length; i++) {
	            buck[nums[i]] +=1;
	        }
	        
	        for(int j=1; j<= 100; j++) {
	            buck[j] += buck[j-1];
	        }
	        
	        for(int k=0; k< nums.length; k++) {
	            int pos = nums[k];
	            nums[k] = pos==0 ? 0 : buck[pos-1];
	        }
	        
	        return nums;
	    }

}
