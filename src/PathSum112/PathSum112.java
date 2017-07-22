package PathSum112;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.val==sum&&root.left==null&&root.right==null)
            return true;
        


        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
            
    }
    /*
     * 为啥不行
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root==null)
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        HashMap<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
        q.offer(root);
        map.put(root, sum-root.val);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left==null&cur.right==null&map.get(cur)==0)
                return true;
            else if(cur.left!=null){
                q.offer(cur.left);
                map.put(cur.left,map.get(cur)-cur.left.val);
            }
            else if(cur.right!=null){
                q.offer(cur.right);
                map.put(cur.right,map.get(cur)-cur.right.val);
            }
        }
        return false;
    }
}
