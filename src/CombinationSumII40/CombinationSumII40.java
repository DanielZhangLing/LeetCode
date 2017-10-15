package CombinationSumII40;

public class CombinationSumII40 {
	
	/*
	 * dfs 加递归 index和index!=i&&candidates[i]==candidates[i-1]控制重复
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res,cur,candidates,target,0,0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int sum,int index){
        if(sum==target){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
            
        if(sum>target)
            return;
        for(int i = index; i< candidates.length; i++){
            if(index!=i&&candidates[i]==candidates[i-1])
                continue;
            cur.add(candidates[i]);
            sum+=candidates[i];
            dfs(res,cur,candidates,target,sum,i+1);
            cur.remove(cur.size()-1);
            sum-=candidates[i];
        }
    }
}
