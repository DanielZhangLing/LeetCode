package ReverseWordsinaString151;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        String[] array = s.trim().split(" ");
        String res = new String();
        for(int i=array.length-1;i>0;i--){
            if(!array[i].equals(""))
                res += array[i] + " ";
        }
        return res+array[0];
        
    }
}
