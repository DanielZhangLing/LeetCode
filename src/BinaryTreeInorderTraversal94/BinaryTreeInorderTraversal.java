package BinaryTreeInorderTraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode current = root;
    	
    	while(current!=null||!stack.isEmpty())
    		if(current!=null){
    			stack.push(current);
    			current = current.left;
    		}
    		else{
    			current = stack.pop();
    			res.add(current.val);
    			current = current.right;   			
    		}
    	return res;
    }
}
