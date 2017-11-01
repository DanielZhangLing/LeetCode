package LowestCommonAncestorofaBinarySearchTree235;

public class LowestCommonAncestorofaBinarySearchTree235 {
	/*
	 * if root>p and root<q that is the answer
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val-p.val)*(root.val-q.val)<1)//including situation root==p==q
            return root;
        else{
            if(root.val>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }else{
                return lowestCommonAncestor(root.right,p,q);
            }
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null)
            return null;
        if(root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null)
            return root;
        return left==null? right:left;
    }
}
