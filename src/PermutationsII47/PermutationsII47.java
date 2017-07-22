package PermutationsII47;

public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0)
            return res;
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res,cur,used,nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> cur, boolean[] used, int[] nums){
        if(cur.size()==nums.length){
            res.add(new ArrayList<Integer>(cur));
        }
        for(int i=0; i<nums.length; i++){
            if(i!=0&&nums[i]==nums[i-1]&&!used[i-1])
//                当i不等于0, nums[i] == nums[i-1]还不够成跳过条件
//                如果前一个number已经用在这个list里，是应该保留这个结果的
//                只有当前一个number没有被用，如果再用这个重复的数，就会duplicate
//                所以加上 used[i-1] == False
                continue;
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
