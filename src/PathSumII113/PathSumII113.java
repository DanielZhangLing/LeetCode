package PathSumII113;

public class PathSumII113 {
	
	/*
	 * recursive 分三种情况
	 * 1.当前节点为空，不处理直接返回
	 * 2.当前结果为正确path的最后一个，加到res中
	 * 3.继续操作左右儿子数
	 */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, sum, path, res);
        return res;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res){
        if(root==null)
            return;
        path.add(root.val);//注意这里已经加到路径里面了
        if(root.left==null&&root.right==null&&sum==root.val){
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        else{
            dfs(root.left, sum-root.val, path,res);
            dfs(root.right, sum-root.val, path,res);
        }
        path.remove(path.size()-1);//因为编辑的是同一个path所以每次当前树完成要往上走的时候要删掉最后一个，这样操作爸爸的兄弟的时候就不会有错
    }
    
    
    
    /*
     * 非递归，使用了stack进行postorder遍历，每次处理完you字数往上走的时候记得删除
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));
  
            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;
        
        }
        return res;
    }
}
