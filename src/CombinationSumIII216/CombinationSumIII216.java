package CombinationSumIII216;

public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(res, cur , k, n, 0, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, int k, int n, int sum ,int index){
        if(k == 0&& sum==n){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if(sum>n)
            return;
        for(int i = index; i<=9; i++){
            cur.add(i);
            sum+= i;
            dfs(res, cur, k-1 ,n , sum, i+1);
            cur.remove(cur.size()-1);
            sum-= i;
            
        }
    }
}
