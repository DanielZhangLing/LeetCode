package ContainsDuplicateIII220;
/*
 * Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array
 *  such that the absolute difference between nums[i] and nums[j] is at most t 
 *  and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII220 {
	/*
	 * Bucketing means we map a range of values to the a bucket.
	 *  For example, if the bucket size is 3, we consider 0, 1, 2 
	 *  all map to the same bucket. However, 
	 *  if t == 3, (0, 3) is a considered duplicates but does not map to the same bucket.
	 *   This is fine since we are checking the buckets immediately before 
	 *   and after as well. So, as a rule of thumb, 
	 *   just make sure the size of the bucket is reasonable such that
	 *    elements having the same bucket is immediately considered duplicates 
	 *    or duplicates must lie within adjacent buckets. 
	 *    So this actually gives us a range of possible bucket size, 
	 *    i.e. t and t + 1. We just choose it to be t and a bucket mapping to be num / t.

Another complication is that negative ints are allowed. 
A simple num / t just shrinks everything towards 0. 
Therefore, we can just reposition every element to start from Integer.MIN_VALUE.
	 */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length == 0||k<1||t<0)
            return false;
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        long w = (long)t+1;// to guarantee in every bucket cannot have two numbers plus one
        for(int i = 0; i< nums.length; i++){
            long input = (long)nums[i]-Integer.MIN_VALUE;// in case negative numbers may show up
            long bId = input/ w;
            if(map.containsKey(bId))
                return true;
            if(map.containsKey(bId-1)&&Math.abs(input-map.get(bId-1))<w)
                return true;
            if(map.containsKey(bId+1)&&Math.abs(map.get(bId+1)-input)<w)
                return true;
            map.put(bId, input);
            if(i>=k)
                map.remove(((long)nums[i-k]-Integer.MIN_VALUE)/w);//if out of k range remove the first
        }
        return false;
    }
    
    
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
