package LicenseKeyFormatting482;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
    	StringBuilder res = new StringBuilder();
    	for(int i = S.length()-1;i>-1;i--){
    		char temp = S.charAt(i);
    		if(temp!='-'){
    			if(res.length()%(K+1)==K)
    				res.append('-');
    			res.append(temp);
    		}
    		continue;
    	}
    	return res.reverse().toString().toUpperCase();
    }
}
