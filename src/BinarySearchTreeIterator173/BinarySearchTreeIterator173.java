package BinarySearchTreeIterator173;

public class BinarySearchTreeIterator173 {
	/*
	 * I use Stack to store directed left children from root.
When next() be called, I just pop one element and process its right child as new root.
The code is pretty straightforward.

So this can satisfy O(h) memory, hasNext() in O(1) time,
But next() is O(h) time.
	 */
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode out = stack.pop();
        TreeNode cur = out.right;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        return out.val;
    }
}
