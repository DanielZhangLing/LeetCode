package LowestCommonAncestorofaBinaryTree236;

public class LowestCommonAncestorofaBinaryTree236 {
	/*
	 * bottom-up找，直接到左右字数里找LCA，然后往上级返回，这里不断recursive其实找到就是 
	 * 它们本来的两个node，如果左右都找到就说明当前node是LCA,只需要O(n)
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
/**
 * To find the lowest common ancestor, 
 * we need to find where is p and q and a way to track their ancestors.
 *  A parent pointer for each node found is good for the job.
 *   After we found both p and q, we create a set of p's ancestors. 
 *   Then we travel through q's ancestors, the first one appears in p's is our answer.
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
