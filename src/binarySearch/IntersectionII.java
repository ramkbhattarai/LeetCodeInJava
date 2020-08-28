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

}
