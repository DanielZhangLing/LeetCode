package BinaryWatch401;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
     
    	List<String> res = new ArrayList<String>();
    	for(int h = 0;h<12;h++)
    		for(int m = 0;m<60;m++){
    			if(Integer.bitCount(h)+Integer.bitCount(m)==num)
    				//res.add(String.format("1%d:2%02d", h,m));
    				res.add(h+":"+(m>=10? m:("0"+m)));
    		}
    	return res;
    			
    }
}
