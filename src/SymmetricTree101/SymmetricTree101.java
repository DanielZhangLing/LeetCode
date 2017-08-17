package SymmetricTree101;

public class SymmetricTree101 {
	/*
	 * key point every time seperate a.left, b.right  with a.right
	 */
    public boolean isSymmetric(TreeNode root) {
        if(root ==null)
            return true;
        return compare(root.left,root.right);
    }
    private boolean compare(TreeNode a, TreeNode b){
        if(a==null&& b==null)
            return true;
        if(a!=null&&b!=null){
            if(a.val==b.val){
                return compare(a.left, b.right)&&compare(a.right, b.left);
            }
        }
        return false;
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if(root==null)  return true;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if(root.left!=null){
            if(root.right==null) return false;
            stack.push(root.left);
            stack.push(root.right);
        }
        else if(root.right!=null){
            return false;
        }
            
        while(!stack.empty()){
            if(stack.size()%2!=0)   return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;
            
            if(left.left!=null){
                if(right.right==null)   return false;
                stack.push(left.left);
                stack.push(right.right);
            }
            else if(right.right!=null){
                return false;
            }
                
            if(left.right!=null){
                if(right.left==null)   return false;
                stack.push(left.right);
                stack.push(right.left);
            }
            else if(right.left!=null){
                return false;
            }
        }
        
        return true;
    }
}
