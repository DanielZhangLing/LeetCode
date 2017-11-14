package ReadNCharactersGivenRead4157;

public class ReadNCharactersGivenRead4157 {
	/*
	 * two limitation:
	 * 1. total>n  out of requirement
	 * 2. read4(xx)<4   end or file
	 * 3. reading process has none business with rea4(??), but with char[] buf
	 */
    public int read(char[] buf, int n) {
        boolean isEnd = false;
        int index = 0;
        char[] cur = new char[4];
        while(!isEnd&&index<n){ 
            int number = read4(cur);
            if(number!=4)
                isEnd = true;
            number = Math.min(number, n-index);
            for(int i = 0; i<number; i++)
                buf[index++] = cur[i];
        }
        return index;
    }
}
