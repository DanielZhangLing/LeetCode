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
}
