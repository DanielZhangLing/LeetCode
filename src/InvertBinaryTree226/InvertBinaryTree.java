package InvertBinaryTree226;

import java.util.Deque;
import java.util.LinkedList;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
    
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
        	return null;
    	TreeNode temp = new TreeNode(0);

    		temp.left = invertTree(root.right);

    		temp.right = invertTree(root.left);
    	temp.val = root.val;
    	return temp;
    }
    public TreeNode invertTree3	(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
