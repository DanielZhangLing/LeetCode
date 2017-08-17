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
    /*
     * bfs
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
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
