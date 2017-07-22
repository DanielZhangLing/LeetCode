package BinaryTreePostorderTraversal145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTreeInorderTraversal94.TreeNode;

/*
 * 用一个cur来track当前到达的点（不是postorder result的顺序，而是当前visit的）
用一个pre来track之前遍历的那个点（postorder中的，所以只在加到result数组的时候更新），对每一个root,依然是不断将left加到stack上到底
当None的时候，是否要往右边走需要判断是否已经visit过right,所以Pre在这里就有了用处
具体步骤是
一开始也是不断地将left child放到stack上,用cur记录当前的node,用pre来记录上一个node（这时候不加到result数组）
当cur为None时，有几种情况
如果当前stack顶元素tmp的右节点存在，并且没有访问过(prev != tmp.right)，就应该往tmp的右边走
否则的话，说明右节点是空的，或者右节点已经访问过了，那么就可以将当前的pop出来加到result里了，这个时候再更新prev
 */
public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            if(null!=cur){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode tmp = stack.peek();
                if(null!=tmp.right&&pre!=tmp.right){
                    cur = tmp.right;
                }
                else{
                    TreeNode top = stack.pop();
                    res.add(top.val);
                    pre = top;
                }
            }
        }
        return res;
    }
}
