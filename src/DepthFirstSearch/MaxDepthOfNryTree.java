package DepthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
 

Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [0, 10^4].
 * @author ramkrishnabhattarai
 *
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class MaxDepthOfNryTree {

	 public int maxDepth(Node root) {
		    if(root == null) { return 0; }
		    int depth = 0;
		    for(Node child : root.children) {
		        depth = Math.max(maxDepth(child), depth);
		    }
		    return depth + 1;
		}
	 // 2 approach 
	 public int maxDepth2(Node root) {
	        return root == null ? 0 : root.children.stream().mapToInt((Node child) -> maxDepth(child) + 1).max().orElse(1);
	    }
	 
	 // 3 approach
	 
	 public int maxDepth3(Node root) {
	        if(root==null) return 0;
	        Queue<Node> queue = new LinkedList<Node>();
	        int level=0;
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            level++;
	            for(int i=0;i<size;i++){
	                Node node=queue.poll();
	                for(Node nextNode : node.children){
	                    queue.offer(nextNode);
	                }
	            }
	        }
	        return level;
	    }
	    
	    public int maxDepth4(Node root) {
	        return dfs(root);
	    }
	    
	    private int dfs(Node root){
	        int max=0;
	        if(root==null) return 0;
	        else if(root!=null && root.children.size()==0) return 1;
	        else if(root!=null && root.children.size() > 0){
	            for(Node node : root.children){
	                int num=dfs(node);
	                if(num>max) max=num;
	            }
	        }
	        return max+1;
	    }
	}

