package ValidateBinarySearchTree98;

public class ValidateBinarySearchTree98 {
	/*
	 * inorder traversal use pre to record the last past node
	 */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode current = root;
        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(pre!=null&&pre.val>=current.val)
                return false;
            else{
                pre = current;
            }
            current = current.right;
        }
        return true;

    }
    
    
    
    
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST2(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST2(root.left, minVal, root.val) && isValidBST2(root.right, root.val, maxVal);
    }
}
