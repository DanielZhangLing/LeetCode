package SumRoottoLeafNumbers129;

public class SumRoottoLeafNumbers129 {
	/*
	 * 不同于答案输出为list，int是不可变对象作为参数传递的是值，所以其实没有公用参数，所以不需要删除操作
	 */
	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s){
		if (n == null) return 0;
		if (n.right == null && n.left == null) return s*10 + n.val;
		return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
	}
}
