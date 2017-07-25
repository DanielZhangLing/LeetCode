package ReverseString344;

/**
 * Created by LingZhang on 5/30/17.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s.equals(""))
            return s;
        char[] str = s.toCharArray();
        for(int i = 0, j = s.length()-1; i<j;i++,j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return new String(str);
    }
}
