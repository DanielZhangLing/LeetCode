package MaximumProductofWordLengths318;

public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
     
    	if(words.equals(null)||words.length==1)
    		return 0;
    	int len = words.length;
    	int[] values = new int[len];
    	for(int i=0;i<len;i++){
    		values[i] = 0;
    		for(int j=0; j<words[i].length();j++){
    			values[i] |= 1<<(words[i].charAt(j)-'a');
    		}
    	}
    	
    	int maxOutput = 0;
    	for(int i=0;i<len;i++)
    		for(int j=i+1;j<len;j++){
    			if((values[i]&values[j])==0&&(words[i].length()*words[j].length())>maxOutput)
    				maxOutput = (words[i].length()*words[j].length());
    		}
    	return maxOutput;
    }
}
