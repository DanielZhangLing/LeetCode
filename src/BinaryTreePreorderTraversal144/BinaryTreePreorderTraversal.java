package BinaryTreePreorderTraversal144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTreeInorderTraversal94.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        res.add(root.val);
        TreeNode current = root.left;

        
        while(!stack.isEmpty()||current!=null){
            if(current!=null){
                res.add(current.val);
                stack.push(current);
                current = current.left;
            }
            else{
                TreeNode temp = stack.pop();
                current = temp.right;
            }
            
        }
        return res;
    }
}
