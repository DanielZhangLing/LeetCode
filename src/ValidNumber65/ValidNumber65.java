package ValidNumber65;

public class ValidNumber65 {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0)
            return false;
        s = s.trim();
        int len = s.length();
        boolean hasFirst = false, hasE = false, hasDigit = false, hasDot = false;
        for(int i=0; i<len; i++){
            char c  = s.charAt(i);
            if(c>='0'&&c<='9'){
                hasFirst = true;
                hasDigit = true;
                continue;
            }
            switch(c){
                case 'e':
                	// already has 'e' or no digit before 'e'
                    if(!hasDigit||!hasFirst||hasE)
                        return false;
                    hasE = true;// reset for the exponential number
                    hasDigit = false;
                    hasFirst = false;
                    hasDot = true;// the exponent must be an integer, hence
					// regard as if a dot exists already. Set
					// hasDot = false extending to accept any
					// (decimal) number as an exponent.
                    break;
                case '+':
                case '-':
                    if(hasFirst)
                        return false;
                    hasFirst = true;
                    break;
                case '.':
                    if(hasDot)
                        return false;
                    hasDot = true;
                    hasFirst = true;
                    break;
                default:
                    return false;
            }
        }
        return hasDigit;
        
    }
}
