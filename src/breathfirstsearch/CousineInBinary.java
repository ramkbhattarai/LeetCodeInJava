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

}
