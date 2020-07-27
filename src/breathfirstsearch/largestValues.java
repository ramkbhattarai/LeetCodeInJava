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

}
