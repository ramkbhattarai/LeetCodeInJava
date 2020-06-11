package DepthFirstSearch;

/**
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 * @author ramkrishnabhattarai
 *
 */

public class SameTree {

	// 1 approach
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    // p and q are both null
	    if (p == null && q == null) return true;
	    // one of p and q is null
	    if (q == null || p == null) return false;
	    if (p.val != q.val) return false;
	    return isSameTree(p.right, q.right) &&
	            isSameTree(p.left, q.left);
	  }
	
	// 2nd approach
	
	 public boolean check(TreeNode p, TreeNode q) {
		    // p and q are null
		    if (p == null && q == null) return true;
		    // one of p and q is null
		    if (q == null || p == null) return false;
		    if (p.val != q.val) return false;
		    return true;
		  }

		  public boolean isSameTree2(TreeNode p, TreeNode q) {
		    if (p == null && q == null) return true;
		    if (!check(p, q)) return false;

		    // init deques
		    ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
		    ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
		    deqP.addLast(p);
		    deqQ.addLast(q);

		    while (!deqP.isEmpty()) {
		      p = deqP.removeFirst();
		      q = deqQ.removeFirst();

		      if (!check(p, q)) return false;
		      if (p != null) {
		        // in Java nulls are not allowed in Deque
		        if (!check(p.left, q.left)) return false;
		        if (p.left != null) {
		          deqP.addLast(p.left);
		          deqQ.addLast(q.left);
		        }
		        if (!check(p.right, q.right)) return false;
		        if (p.right != null) {
		          deqP.addLast(p.right);
		          deqQ.addLast(q.right);
		        }
		      }
		    }
		    return true;
		  }
}
