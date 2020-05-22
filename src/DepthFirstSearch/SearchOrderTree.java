package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * @author ramkrishnabhattarai
 *
 */



public class SearchOrderTree {
	public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
    // 2nd approach
    
    TreeNode cur;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder2(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
    
    // 3rd approach
    
    public TreeNode increasingBST(TreeNode root) {
        
        List<TreeNode> myList=new ArrayList();
        myList=inOrderTrav(root,myList);
        
       TreeNode newNode=myList.get(0);
        TreeNode currentNode=newNode; 
        for(int i=1;i<myList.size();i++)
        {
            currentNode.right=myList.get(i);
            currentNode.left=null; 
            currentNode=currentNode.right;
        }
        return newNode;
    }
    
    public List<TreeNode> inOrderTrav(TreeNode root,List<TreeNode> myList)
    {
        if(root==null)
            return myList;  
        inOrderTrav(root.left,myList);
        myList.add(root);
        inOrderTrav(root.right,myList);
        
        return myList;
    }
}
