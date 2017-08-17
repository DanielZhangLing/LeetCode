package BalancedBinaryTree110;

public class BalancedBinaryTree110 {
	/*
	 * 这一题也是用recursive的方法做
对于每一个root,分别get左右两边子树的max depth
如果balanced，就继续recursive的检查左右子树
	 */
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    
    
    public boolean isBalanced2(TreeNode root) {
        if(root==null){
            return true;
        }
        return height(root)!=-1;
        
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lH=height(node.left);
        if(lH==-1){
            return -1;
        }
        int rH=height(node.right);
        if(rH==-1){
            return -1;
        }
        if(lH-rH<-1 || lH-rH>1){
            return -1;
        }
        return Math.max(lH,rH)+1;
    }
}
