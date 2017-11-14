package SlidingWindowMaximum239;

public class SlidingWindowMaximum239 {
	/**
	 * keep the first element the biggest in the window
	 * @param nums
	 * @param k
	 * @return
	 */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0)
            return new int[0];
        int len = nums.length;
        int[] res = new int[len-k+1];
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0 ; i <len; i++){
        	// if the biggest in the window's index is not in the window then poll
            while(!q.isEmpty()&&q.peek()<i-k+1)
                q.poll();
            // always keep the biggest in the first
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i])
                q.pollLast();
            q.add(i);
            if(i>=k-1)
                res[i-k+1] = nums[q.peek()];
        }
        return res;
    }
}
