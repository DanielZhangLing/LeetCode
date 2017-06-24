package StringtoInteger8;

public class StringtoInteger {

    public int myAtoi(String str) {
        if(null==str||str.length()==0)
            return 0;
        char[] arr = str.trim().toCharArray();
        int res = 0;
        int flag = 1;
        int i=0;
        if('-'==arr[0]){
            flag = -1;
            i++;
        }
        if('+'==arr[0]){
            i++;
        }
        for(; i<arr.length;i++){
            int newRes = 0;
            if(arr[i]-'0'>9||arr[i]-'0'<0)
                break;
            else
                newRes = res*10+arr[i]-'0';
            if(flag==1&&(Integer.MAX_VALUE-(arr[i]-'0'))/10<res){
                return Integer.MAX_VALUE ;
            }
            if(flag==(-1)&&(Integer.MIN_VALUE+(arr[i]-'0'))/10>(0-res))
                return Integer.MIN_VALUE ;
            res = newRes;
        }
        res = flag*res;
        return res;
}
}
