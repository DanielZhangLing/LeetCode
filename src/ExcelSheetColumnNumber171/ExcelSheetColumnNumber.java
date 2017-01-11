package ExcelSheetColumnNumber171;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for(int i=0;i<s.length();i++){
        	result += (s.charAt(i)-'A'+1) * Math.pow(26,(n-1)) ;
        	n--;
        }
        return result;
    }
}
