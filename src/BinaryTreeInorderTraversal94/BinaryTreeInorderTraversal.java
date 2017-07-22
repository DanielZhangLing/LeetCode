package BinaryTreeInorderTraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 我们要用一个cur来保存当前到达的节点（不是记录到result里的节点，而是要Push到stack上的）
因为stack是后进后出的，所以一开始可以先将root加到stack,并且不断地将left child加到stack
只有当curr为None的时候，说明当前已经肯定没有left child，这时候才从stack里pop出来一个加到result数组里, 然后继续往right child走（如果有的话）
如果没有right child, 那么cur还是None，stack又会pop，就又到了上面的node
 */

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode current = root;
    	
    	while(current!=null||!stack.isEmpty())
    		if(current!=null){
    			stack.push(current);
    			current = current.left;
    		}
    		else{
    			current = stack.pop();
    			res.add(current.val);
    			current = current.right;   			
    		}
    	return res;
    }
}
