package breathfirstsearch;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author ramkrishnabhattarai
 *
 */

public class LevelOrder {
	
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        Stack<List<Integer>> levels = new Stack<>();
	        if(root != null) {
	            nodeQueue.offer(root);
	        }
	        while(!nodeQueue.isEmpty()) {
	            int qSize = nodeQueue.size();
	            List<Integer> level = new ArrayList<>();
	            for (int i = 0; i < qSize; i++) {
	                TreeNode curr = nodeQueue.poll();
	                level.add(curr.val);
	                if(curr.left != null) nodeQueue.offer(curr.left);
	                if(curr.right != null) nodeQueue.offer(curr.right);
	            }
	            levels.push(level);
	        }

	        List<List<Integer>> res = new ArrayList<>();
	        while(!levels.isEmpty()) {
	            res.add(levels.pop());
	        }
	        return res;
	    }
	 
	 // 2nd approach
	 public  List<List<Integer>> levelOrderBottom(TreeNode root) {
	        List<List<Integer>> ans = new ArrayList<>();
	        levelOrderBottom(root, ans, 0);
	        return ans;
	    }

	    private static void levelOrderBottom(TreeNode node, List<List<Integer>> ans, int depth) {
	        
	        if (node == null) return;

	        if (ans.size() <= depth) {
	            ans.add(0, new ArrayList<>());
	        }
			
	        ans.get(ans.size() - depth - 1).add(node.val);
	        
	        levelOrderBottom(node.left, ans, depth + 1);
	        levelOrderBottom(node.right, ans, depth + 1);
	    }
	    
	    // 3rd approach
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	        if (root == null) {
	            return new LinkedList();
	        }
	        List<List<Integer>> lists = new LinkedList();
	        Deque<TreeNode> deque = new ArrayDeque(); // use deque as a queue
	        deque.add(root);
	        while (!deque.isEmpty()) {
	            int numNodesInLevel = deque.size();
	            List<Integer> level = new ArrayList(numNodesInLevel);
	            while (numNodesInLevel-- > 0) {
	                TreeNode n = deque.remove();
	                level.add(n.val);
	                if (n.left != null) {
	                    deque.add(n.left);
	                }
	                if (n.right != null) {
	                    deque.add(n.right);
	                }
	            }
	            lists.add(0, level);
	        }
	        return lists;
	    }

}
