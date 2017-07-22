package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTreeInorderTraversal94.TreeNode;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode temp = null;
            for(int i = 0; i<size; i++){
                temp = q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            res.add(temp.val);
        }
        return res;
    }
    
     
}
