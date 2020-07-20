package breathfirstsearch;

/**
 * n a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 * @author ramkrishnabhattarai
 *
 */

public class CousineInBinary {
	
	public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(q.size()>0){
            List<Integer> level = new ArrayList();
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = q.remove();
                if(temp.left != null && temp.right != null){
                    if(temp.left.val == x && temp.right.val == y)
                        return false;
                    if(temp.right.val == x && temp.left.val == y)
                        return false;
                }
                level.add(temp.val);
                    
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            if(level.contains(x) && level.contains(y))
                return true;
        }
        
            return false;
    }
	
	
public boolean isCousins(TreeNode root, int x, int y) {
        
        //If any of x or y is at root, it means they can't be at same depth. Return false.
        if(root.val == x || root.val == y) return false;
        
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean xFound = false;
        boolean yFound = false;
        
        int parentX = 0;
        int parentY = 0;
        
        //Do level-order traversal until x or y is found or queue is empty.
        while(!queue.isEmpty() && !xFound && !yFound){
            
            int size = queue.size();
			
            //Traverse that level.
            while(size-- > 0){
                TreeNode node = queue.poll();
				
                //if x or y is found at left/right, save the parent and set the "found" flag to true.
                //This flag will break the loop as soon as any one (x or y) is found. 
				//we don't need to go deeper to find second if it isn't found at this level.
				
                if(node.left != null) {
                    queue.offer(node.left);
                    
                    if(node.left.val == x){
                        parentX = node.val;
                        xFound = true;
                    }
                    if(node.left.val == y){
                        parentY = node.val;
                        yFound = true;
                    }
                    
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    
                    if(node.right.val == x){
                        parentX = node.val;
                        xFound = true;
                    }
                    if(node.right.val == y){
                        parentY = node.val;
                        yFound = true;
                    }
                }
            }
            
        }
        return xFound && yFound && parentX != parentY;
    }

}
