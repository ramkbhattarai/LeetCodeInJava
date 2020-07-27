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
    
    
    public List<Integer> largestValues3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        if(root==null) return list;
        
        int max=Integer.MIN_VALUE;
        queue.offer(root);
        while(!queue.isEmpty()){
            max=Integer.MIN_VALUE;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.val > max) max=node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }
    
    
    
    
    public List<Integer> largestValues4(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        dfs(root,list,1);
        return list;
    }
    
    private void dfs(TreeNode root,List<Integer> list, int depth){
        if(root==null) return;
        if(depth > list.size()) list.add(root.val);
        else list.set(depth-1,Math.max(root.val,list.get(depth-1)));
        
        if(root.left!=null) dfs(root.left,list,depth+1);
        if(root.right!=null) dfs(root.right,list,depth+1);
    }

}
