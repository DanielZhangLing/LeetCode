package SubarraySumEqualsK560;

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0,res = 0;
        for(int i = 0 ; i <nums.length; i++){
            sum+= nums[i];
            int need = sum-k;
            if(map.containsKey(need)){
                res+=map.get(need);
            }
            if(map.containsKey(sum))
                map.put(sum,map.get(sum)+1);
            else{
                map.put(sum, 1);
            }
            
        }
        return res;
    }
}
