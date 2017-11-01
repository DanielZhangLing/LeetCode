package ValidPalindromeII680;

public class ValidPalindromeII680 {
    public boolean validPalindrome(String s) {
        if(s.length()==0)
            return false;
        int left = 0, right = s.length()-1;
        while(right>left){
            if(s.charAt(right)!=s.charAt(left))
                return isPalindrome(s, left, right-1)||isPalindrome(s, left+1, right);
            right--;
            left++;
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int left,int right){
        while(right>left){
            if(s.charAt(right)!=s.charAt(left))
                return false;
            right--;
            left++;
        }
        return true;
    }
}
