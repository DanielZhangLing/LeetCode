package BinaryTreePaths257;

public class BinaryTreePaths257 {

	/*
	 * dfs 每次用一个string path追踪
	 */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null)
            return res;
        dfs(root, "", res);
        return res;
    }
    
    private void dfs(TreeNode root, String path, List<String> res){
        if(root.left==null&&root.right==null){
            res.add(path+root.val);
            return;
        }
        if(root.left!=null){
            dfs(root.left, path+root.val+"->",res);
        }
         if(root.right!=null){
            dfs(root.right, path+root.val+"->",res);
        }
        
        return;
    }
}
