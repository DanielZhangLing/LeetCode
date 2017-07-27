package CombinationSum39;

public class CombinationSum39 {
	/*
	 * 递归加bfs，用index限制重复，注意进入下一层的时候index =i可以重复自己，但不能重复比自己小的
	 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            cur.add(candidates[i]);
            sum+=candidates[i];
            dfs(res,cur,candidates,target,sum,i);
            cur.remove(cur.size()-1);
            sum-=candidates[i];
        }
    }
}
