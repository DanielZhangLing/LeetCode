package SubsetsII90;

public class SubsetsII90 {
	/*
	 * 要求non-descending,所以我们再生成subset之前应该将原list sort一下，这样 后面才可以方便的处理，包括去掉重复的数的操作也会更方便
	 * 可以看出前后subset之间的关系，我们可以用类似dfs的方法做，对当前的List将下一个num加进去进行dfs, 得到所有的subsets,然后再pop掉，对下一个num进行DFS
	 * 与subsets 1相比，要去掉重复的subsets,因为我们已经sort过，所以可以方便地去掉。 如果当前的number在之前已经用过dfs过，那么当前的dfs结果一定被包含了，所以可以直接跳过。
	 * i != index 意为在每一次扩展树枝的第一次是记录入结果的如果有2，2出现
	 */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if(index!=i&&nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            dfs(res,nums,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}
