package binarySearch;

public class KWeakestRow {
	
	public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];

        //gather soldiers count into single dimensional array(per row)
        int[] counts = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    counts[i]++;
                }
            }
        }

        int indexer = 0;
        while (k > 0) {
            //make linear search k times and take minimum index to fill in result array
            int minIndex = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] < counts[minIndex]) {
                    minIndex = i;
                }
            }

            result[indexer++] = minIndex;
            counts[minIndex] = Integer.MAX_VALUE;
            k--;
        }

        return result;
    }
	
	
	public int[] kWeakestRows2(int[][] mat, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int i = 0; i < rows; i++) {            
            int j = 0;
            while (j < cols && mat[i][j] != 0) {                
                j++;
            }
            if (!map.containsKey(j)) {
                map.put(j, new ArrayList<>());
            }
            map.get(j).add(i);
        }
        
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            List<Integer> list = map.get(map.firstKey());
            for (int j = 0; j < list.size() && i < k; j++) {                
                res[i++] = list.get(j);
            }  
            map.remove(map.firstKey());
        }
        return res;        
    }
	
	
	 public int[] kWeakestRows3(int[][] mat, int k) {
	        HashSet<Integer> set = new HashSet<>();
	        int temp =0;
	        ArrayList<Integer> list = new ArrayList<>();
	        int soldiers = 0;
	        int[] res = new int[k];
	        for(int i = 0; i< mat.length; i++){
	            for(int j = 0; j< mat[0].length; j++){
	                  if(mat[i][j] == 1 ) soldiers++;
	            }
	             
	            list.add(soldiers);
	            mat[i][0] = soldiers; 
	            soldiers = 0;
	            mat[i][1] = i;
	            
	        }
	         Collections.sort(list);
	      
	    for(int y = 0; y < k; y++){
	                temp = list.get(y);

	        for(int x = 0; x < mat.length; x++){
	            if(mat[x][0] == temp && !set.contains(mat[x][1])){
	                res[y] = mat[x][1];
	                set.add(mat[x][1]);
	             
	                break;
	            }
	        }
	    }
	                    return res;

	    }

}
