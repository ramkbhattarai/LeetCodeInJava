package breathfirstsearch;

/**
 * You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
 * @author ramkrishnabhattarai
 *
 */
public class largestValues {
	
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        findLevelLargest(root,res,0);
        return res;
    }
    
    private void findLevelLargest(TreeNode node, List<Integer> res,int level) {
        
        if ( node == null) return;
    
        if (res.size() < (level+1)){
            res.add(level,node.val);
         } else { 
          if (node.val > res.get(level)) {  
            res.remove(level);  
            res.add(level, node.val);
          }
        }
        
        findLevelLargest(node.left,res,level+1);
        findLevelLargest(node.right,res,level+1);
        
    }
    
    
    public List<Integer> largestValues2(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
    	if (root == null)
    		return ans;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	ans.add(root.val);
    	while (!q.isEmpty()) {
    		Queue<TreeNode> children = new LinkedList<>();
    		Integer max = null;
    		while (!q.isEmpty()) {
    			TreeNode node = q.poll();
    			if (max == null) {
    				if (node.left != null)
    					max = node.left.val;
    				else if (node.right != null)
    					max = node.right.val;
    			}
    			if (node.left != null) {
    				max = Math.max(max, node.left.val);
    				children.add(node.left);
    			}
    			if (node.right != null) {
    				max = Math.max(max, node.right.val);
    				children.add(node.right);
    			}
    		}
    		if (max != null)
    			ans.add(max);
    		q = children;
    	}
    	return ans;
    }

}
