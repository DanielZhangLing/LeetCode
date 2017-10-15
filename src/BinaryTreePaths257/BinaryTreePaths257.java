<<<<<<< Updated upstream
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
=======
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
    //BFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
        Queue<String> qStr=new LinkedList<String>();
        
        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();
            
            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }
        return list;
    }
    
public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;
        
        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;
        
    }
}
>>>>>>> Stashed changes
