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
}
