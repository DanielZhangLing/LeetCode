package Sqrt;

public class Sqrt {
	
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int low = 1, high = x;
        while(low+1<high){
            int mid = low+(high-low)/2;
            if(mid==x/mid)
                return mid;
            if(mid>x/mid){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low>x/low? high:low;// check boundary case
    }
	public int sqrt(int x) {
		// write your code here
//use divide special case
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {// use divide because x maybe equals MAX_VALUE
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}

		}
	}
}
