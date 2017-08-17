package CountandSay38;

public class CountandSay38 {
	
    public String countAndSay(int n) {
        String[] res = new String[n];
        res[0] = "1";
        for(int i = 1;i<n;i++){
            String str = res[i-1];
            if(str.length()==1){
                res[1] = "11";
                continue;
            }
            
            StringBuilder curr=new StringBuilder();

            int count=1;
            for(int j = 1; j<str.length(); j++){
                if(str.charAt(j)!=str.charAt(j-1)){
                    curr.append(count);
                    curr.append(str.charAt(j-1));
                    count =1;
                }
                else{
                    count++;
                }
            }
            curr.append(count);
            curr.append(str.charAt(str.length()-1));
            res[i] = new String(curr);
        }
        return res[n-1];
    }
}
