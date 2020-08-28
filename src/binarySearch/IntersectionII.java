package binarySearch;

public class IntersectionII {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length) {
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++) {
            if(map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i])+1);
            }
            else
                map.put(nums1[i], 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums2.length;i++) {
            if(map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i])>=0)
                    list.add(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            arr[i]=list.get(i);
        }
        return arr;
        
    }
	
	public int[] intersectII(int[] nums1, int[] nums2) {
        //for result array intersection 
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        //hash set to keep track of counts of numbers
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        //iterate through nums1
        for (int i = 0; i < nums1.length; i++) {
            //check if already in counts
            if (counts.containsKey(nums1[i])) {
                //increment count
                counts.put(nums1[i], counts.get(nums1[i]) + 1);
            } else {
                //need to add it
                counts.put(nums1[i], 1);
            }
        }
        
        //iterate through nums2
        for (int i = 0; i < nums2.length; i++) {
            //check if counts contains this number, and that count is not 0
            if (counts.containsKey(nums2[i]) && counts.get(nums2[i]) != 0) {
                //add to result
                res.add(nums2[i]);
                //decrement count
                counts.put(nums2[i], counts.get(nums2[i]) - 1);
            }
        }
        
        //convert arraylist to array and result
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
}

}
