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
}
