package ReadNCharactersGivenRead4157;

public class ReadNCharactersGivenRead4157 {
	/*
	 * two limitation:
	 * 1. total>n  out of requirement
	 * 2. read4(xx)<4   end or file
	 * 3. reading process has none business with rea4(??), but with char[] buf
	 */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] temp = new char[4];
        while(true){
            int cnt = read4(temp);
            for(int i=0; i<cnt && total<n;i++){
                buf[total++] = temp[i];
            }
            if(total==n||cnt==0){
                return total;
            }
        }
    }
}
