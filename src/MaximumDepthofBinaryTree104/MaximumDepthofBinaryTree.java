package MaximumDepthofBinaryTree104;

import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
    public static int maxDepth(TreeNode root) {  
if (root == null) {  
    return 0;  
}  

int leftDepth = maxDepth(root.left);  
int rightDepth = maxDepth(root.right);  
return Math.max(leftDepth, rightDepth) + 1;  
}  
    
    public static int maxDepth2(TreeNode root){
    	if (root == null) {  
    	    return 0;  
    	}
    	int currentLevelNode = 1;
    	int nextLevelNode = 0;
    	int depth = 0;
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);  
    	while(currentLevelNode!= 0){
	    	TreeNode curNode = queue.remove();
	    	currentLevelNode--;
	    	if(curNode.left!= null)
	    	{
	    		queue.add(curNode.left);
	    		nextLevelNode++;
	    	}
	    	if(curNode.right!= null)
	    	{
	    		queue.add(curNode.right);
	    		nextLevelNode++;
	    	}
	    	if(currentLevelNode == 0)
	    	{
	    		depth++;
	    		currentLevelNode = nextLevelNode;
	    		nextLevelNode = 0;
	    	}
	}
    	return depth;
    }

    public static void main(String[] args) {  
        TreeNode r1 = new TreeNode(1);  
        TreeNode r2 = new TreeNode(2);  
        TreeNode r3 = new TreeNode(3);  
        TreeNode r4 = new TreeNode(4);  
        TreeNode r5 = new TreeNode(5);  
        TreeNode r6 = new TreeNode(6);  
          
        r1.left = r2;  
        r1.right = r3;  
        r2.left = r4;  
        r2.right = r5;  
        r3.right = r6;  
        
        System.out.println(maxDepth2(r1)); 
    }
	
}
