package ConvertSortedArraytoBinarySearchTree108;
/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree108 {
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length == 0 )
            return null;
        return dfs(nums, 0 , nums.length-1);
    }
    
    private TreeNode dfs(int[] nums, int l, int r){
        if(r-l+1<1)// base case
            return null;
        int mid = (r+l)/2;
        if((r+l)%2 == 1)//odd
            mid++;  
        TreeNode now = new TreeNode(nums[mid]);
        TreeNode left = dfs(nums, l, mid-1);
        TreeNode right = dfs(nums, mid+1, r);
        now.left = left;
        now.right = right;
        return now;
    }
}
