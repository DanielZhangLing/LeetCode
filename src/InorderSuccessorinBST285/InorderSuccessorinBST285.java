package InorderSuccessorinBST285;

public class InorderSuccessorinBST285 {
	/*
	 * The inorder traversal of a BST is the nodes in ascending order. 
	 * To find a successor, 
	 * you just need to find the smallest one that is larger than the given value
	 *  since there are no duplicate values in a BST. 
	 *  It just like the binary search in a sorted list.
	 *   The time complexity should be O(h) where h is the depth of the result node. 
	 *   succ is a pointer that keeps the possible successor. 
	 *   Whenever you go left the current root is the new possible successor, 
	 * otherwise the it remains the same.
	 */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode suc = null;
        while(root!=null){
            if(p.val<root.val){
                suc = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return suc;
    }
	
	public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}
public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}
}
