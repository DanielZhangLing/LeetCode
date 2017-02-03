package BinaryTreeVerticalOrderTraversal314;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTreeInorderTraversal94.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	
	 public List<List<Integer>> verticalOrder(TreeNode root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(root==null)
	    		return result;
	        int max = 0, min = 0;
	        
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        Queue<Integer> index = new LinkedList<Integer>();
	        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	        q.offer(root);
	        index.offer(0);
	        
	        while(!q.isEmpty()){
	            TreeNode current = q.poll();
	            int i = index.poll();
	            if(i<min)
	                min =i;
	            if(i>max)
	                max =i;
	            if(map.get(i)==null)
	                map.put(i, new ArrayList<Integer>());
	            map.get(i).add(current.val);
	            if(current.left!=null){
	                q.offer(current.left);
	                index.offer(i-1);
	            }
	            if(current.right!=null){
	                q.offer(current.right);
	                index.offer(i+1);
	            }
	        }
	        for(int i=min;i<=max;i++){
	            
	            if(map.get(i)!=null)
	                result.add(map.get(i));
	        }
	        return result;
	        
	    }
}
