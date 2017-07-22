package Subsets78;

import SubsetsII90.ArrayList;
import SubsetsII90.List;

public class Subsets78 {
	/*
	 * 一共包含了n^2种情况，可以看作一个指针放在nums，每移动一格，把res里的全部扫描一遍加上当前数字，在加到res
	 */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int size = res.size();
            for(int j = 0; j<size; j++){
                List<Integer> cur = new ArrayList<Integer>(res.get(j));
                cur.add(nums[i]);
                res.add(cur);
            }
        }
        return res;
    }
    
    /*
     * DFS+recursive
     * 要求non-descending,所以我们再生成subset之前应该将原list sort一下，这样 后面才可以方便的处理，包括去掉重复的数的操作也会更方便
	 * 可以看出前后subset之间的关系，我们可以用类似dfs的方法做，对当前的List将下一个num加进去进行dfs, 得到所有的subsets,然后再pop掉，对下一个num进行DFS
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>());
        if(nums==null||nums.length==0)
            return res;
        Arrays.sort(nums);
        dfs(res,nums,0,cur);
        return res;
    }
    
    public void dfs(List<List<Integer>> res,int[] nums, int index, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i = index; i<nums.length; i++){
            cur.add(nums[i]);
            dfs(res,nums,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
