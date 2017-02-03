package SerializeandDeserializeBST449;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTreeInorderTraversal94.TreeNode;

public class SerializeandDeserializeBST {

    public static String serialize(TreeNode root) {
        
    	if(root==null) return "";
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	StringBuilder sb = new StringBuilder();
    	while(root!=null||!stack.isEmpty()){
    		while(root!=null){
    			sb.append(root.val);
    			sb.append(",");
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		root = root.right;
    	}
    	
    	String data = sb.toString();
    	return data;
    }
    	

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        
    	if(data.isEmpty()||data==""||data==null) return null;
    	String[] dataA = data.split(",");
    	Queue<Integer> q = new LinkedList<Integer>();
    	for(String s:dataA)
    		q.offer(Integer.parseInt(s));
    	return getNode(q);
    	
    }


	private static TreeNode getNode(Queue<Integer> q) {
		// TODO Auto-generated method stub
		if(q.isEmpty()) return null;
		TreeNode current = new TreeNode(q.poll());
		Queue<Integer> temp = new LinkedList<Integer>(); 
		while(!q.isEmpty()&&q.peek()<current.val){
			temp.offer(q.poll());			
		}
		current.left =  getNode(temp);
		current.right = getNode(q);
		return current;
	}
	
	public static void main(String[] args){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		//System.out.println(deserialize(serialize()));
	}
}
