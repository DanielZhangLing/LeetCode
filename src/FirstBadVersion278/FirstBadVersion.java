package FirstBadVersion278;

/**
 * Created by LingZhang on 5/14/17.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l+1<r){
            int mid = l+ (r-l)/2;
            if(isBadVersion(mid)){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        if(isBadVersion(l)){
            return l;
        }
        else{
            return r;
        }
    }
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;            
        }        
        return start;
    }
}
