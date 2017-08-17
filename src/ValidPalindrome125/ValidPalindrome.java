package ValidPalindrome125;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start<=end){
            char l = s.charAt(start);
            char r = s.charAt(end);
            if(!Character.isAlphabetic(l)&&!Character.isDigit(l)){
                start++;
            }
            else if(!Character.isAlphabetic(r)&&!Character.isDigit(r)){
                end--;
            }
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
	
	public static void test(String data){
		
		System.out.println(isPalindrome(data));
	}
	
	public static void main(String[] args){
		test("0p");
	}
}
