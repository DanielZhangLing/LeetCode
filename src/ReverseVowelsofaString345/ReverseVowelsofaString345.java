package ReverseVowelsofaString345;

public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        if(s==null||s.length()==0)
            return s;
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int start = 0 , end = s.length()-1;
        while(end>start){
            while(end>start&&!vowels.contains(array[start]+"")){
                start++;
            }
            while(end>start&&!vowels.contains(array[end]+"")){
                end--;
            }
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return new String(array);
    }
}
