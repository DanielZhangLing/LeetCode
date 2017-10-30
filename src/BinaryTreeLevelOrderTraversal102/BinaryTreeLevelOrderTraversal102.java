package BinaryTreeLevelOrderTraversal102;

public class BinaryTreeLevelOrderTraversal102 {
	/*
	 * BFS用stack 每层先创建一个size，来跑for循环
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(null==root){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curList = new ArrayList<Integer>();
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                curList.add(cur.val);
                if(null!=cur.left){
                    q.add(cur.left);
                }
                if(null!=cur.right){
                    q.add(cur.right);
                }
            }
            res.add(curList);
        }
        return res;
    }
    
    
    //dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
