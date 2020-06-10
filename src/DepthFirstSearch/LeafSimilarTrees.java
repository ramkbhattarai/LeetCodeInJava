package DepthFirstSearch;


/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * @author ramkrishnabhattarai
 *
 */
public class LeafSimilarTrees {
	
	
	// 1 approach
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
    
    // 2 approach
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<Integer>();
        List<Integer> leafs2 = new ArrayList<Integer>();
        dfs(root1, leafs1);
        dfs(root2, leafs2);
        return leafs1.equals(leafs2);
    }
    
    public void dfs(TreeNode root, List leafs){
        if (root == null){
            return;
        }
        if (root.left == null && root.right ==null){
            leafs.add(root.val);
        }
        dfs(root.right, leafs);
        dfs(root.left, leafs);
    }
    
    // 3rd approach
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String tree1 = "";
        String tree2 = "";
        
        tree1 = leafs(tree1, root1);
        tree2 = leafs(tree2, root2);
        
        if(tree1.equals(tree2)) return true;
        return false;
    }
    
    
    public String leafs(String tree, TreeNode root) {
        if(root.left == null && root.right == null) {
            tree = tree + root.val;
            return tree;
        }
        
        tree = (root.left != null) ? leafs(tree, root.left) : tree;
        tree = (root.right != null) ? leafs(tree, root.right) : tree;
        
        return tree;
    }

}
