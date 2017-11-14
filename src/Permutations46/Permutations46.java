package Permutations46;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(res,cur,used,nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, boolean[] used, int[] nums){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }
        for(int i=0; i<nums.length; i++){
            if(used[i])
                continue;
            else{
                cur.add(nums[i]);
                used[i]=true;
                dfs(res,cur,used,nums);
            }
            used[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
