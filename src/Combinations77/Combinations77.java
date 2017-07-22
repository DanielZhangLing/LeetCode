package Combinations77;

public class Combinations77 {
	/*
	 * recurseive dfs 用index来保证没有像1，4  4，1这样的出现
	 */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==0||k==0)
            return res;
        List<Integer> cur = new ArrayList<Integer>(k);
        dfs(res,cur,n,k,1);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> cur,  int n, int k, int index){
        if(k==0){
            res.add(new ArrayList(cur));
        }
        for(int i = index; i<=n; i++){
            cur.add(i);
            dfs(res,cur,n,k-1, i+1);
            cur.remove(cur.size()-1);
        }

    }
}
