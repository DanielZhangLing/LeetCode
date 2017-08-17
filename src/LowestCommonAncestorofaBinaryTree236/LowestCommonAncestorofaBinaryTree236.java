package LowestCommonAncestorofaBinaryTree236;

public class LowestCommonAncestorofaBinaryTree236 {
	/*
	 * bottom-up找，直接到左右字数里找LCA，然后往上级返回，这里不断recursive其实找到就是 它们本来的两个node，如果左右都找到就说明当前node是LCA,只需要O(n)
经验总结

如果有多次重复的问题，那么找出每次重复之间的子问题关系，将重复的量去掉
树的recursive不一定要先判断当前的node，如果子树的信息对当前node有用，可以先判断子树变为bottom-up的做法
树的bottom-up和top-down的主要差别就是： 先处理当前节点还是先处理子树
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        return left!=null? left:right;
    }
    /*
     * 方法1

对于每一个node
如果和p或者q相等，那么这就是LCA
检查p和q在它的哪一边，如果是在两边的话，这个就是LCA
如果在同一边的话，就往左或者往右
这个算法worst case的时间复杂度是O(n^2)
     */
}
