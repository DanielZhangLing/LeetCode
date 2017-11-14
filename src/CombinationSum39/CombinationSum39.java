package CombinationSum39;

public class CombinationSum39 {
	/*
	 * 递归加bfs，用index限制重复，注意进入下一层的时候index =i可以重复自己，但不能重复比自己小的
	 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, target, 0, 0, new ArrayList<>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] candidates, int target, int index, int sum, List<Integer> path){
        if(sum>target)
            return;
        if(sum==target)
            res.add(new ArrayList<>(path));
        for(int i = index; i <candidates.length; i++){
            path.add(candidates[i]);
            dfs(res, candidates, target, i, sum+candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}
