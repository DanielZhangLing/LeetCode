package Subsets78;

import SubsetsII90.ArrayList;
import SubsetsII90.List;

public class Subsets78 {
	/*
	 * 一共包含了n^2种情况，可以看作一个指针放在nums，每移动一格，把res里的全部扫描一遍加上当前数字，在加到res
	 */
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		if (S == null || S.length == 0)
			return res;

		for (int i : S) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> item = new ArrayList<Integer>(res.get(j));
				item.add(i);
				res.add(item);
			}
		}
		return res;
	}

	/*
	 * DFS+recursive 要求non-descending,所以我们再生成subset之前应该将原list sort一下，这样
	 * 后面才可以方便的处理，包括去掉重复的数的操作也会更方便
	 * 可以看出前后subset之间的关系，我们可以用类似dfs的方法做，对当前的List将下一个num加进去进行dfs,
	 * 得到所有的subsets,然后再pop掉，对下一个num进行DFS
	 */
	public List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
}
