package KthSmallestElementinaBST230;

import java.util.Stack;

import BinaryTreeInorderTraversal94.TreeNode;

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        
    	int count = countNode(root.left);
    	if(k<=count){
    			return kthSmallest(root.left, k	);
    	}
    	else if(k==count+1)
        	return root.val;
    	else
    		return kthSmallest(root.right, k-count-1	);

    }
    public int countNode(TreeNode root){
    	if (root==null)
    		return 0;
    	else return 1+countNode(root.left)+countNode(root.right);
    }
    
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
    
    public int kthSmallest23(TreeNode root, int k){
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(root!=null){
    		stack.push(root.left);
    		root = root.left;
    	}
    	
    	while(!stack.isEmpty()){
    		root = stack.pop();
    		k--;
    		if(k==0)
    			return root.val;
    		else{
    			root = root.right;
    			if(root!=null){
    				stack.push(root);
    				root = root.left;
    			}
    		}
    	}
    	return -1;
    }
}
