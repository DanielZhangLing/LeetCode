package InvertBinaryTree226;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left,
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
}
