package DepthFirstSearch;

public class IsBalancedTree {
	// 1st approach
	public boolean isBalanced(TreeNode root) {
		if (root == null){
		return true;
		}
		if (Math.abs(depth(root.left) - depth(root.right)) > 1){
		return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
		}
		public int depth(TreeNode root){
		if (root == null){
		return 0;
		}
		return Math.max(depth(root.left),depth(root.right)) + 1;
		}
		
		 boolean ans = true;
		    public boolean isBalanced2(TreeNode root) {
		        helper(root);
		        return ans;
		    }
		    public int helper(TreeNode root){
		        if(root == null || !ans) return 0;
		        int left = helper(root.left);
		        int right = helper(root.right);
		        if(Math.abs(left - right) > 1) ans = false;
		        return 1 + Math.max(left, right);
		    }
		    
		    
		    boolean isB = true;
		    
		    public boolean isBalanced3(TreeNode root) {
		        checkB(root);
		        return isB;
		    }
		    
		    int checkB(TreeNode cur) {
		        if (cur == null) return 0;
		        int lH = checkB(cur.left);
		        int rH = checkB(cur.right);
		        
		        int diff = Math.abs(lH - rH); //check for balance on each node, everything else is simple tree height
		        if (diff > 1) isB = false;
		        
		        return Math.max(lH, rH) + 1;
		    }

}
