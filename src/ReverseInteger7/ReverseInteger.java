package ReverseInteger7;

public class ReverseInteger {
    public int reverse(int x) {
        if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE)
            return 0;
        boolean flag = false;
        
        if (x<0)
            flag = true;
        
        x=Math.abs(x);
    
        String s = Integer.toString(x);
        s = new StringBuffer(s).reverse().toString();
        int result;
        try {
            result = flag?(-1)*Integer.valueOf(s):Integer.valueOf(s);
        }
        catch(Exception e){
        	   return 0;         
        }
        return result;
    }
    public int reverse2(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    public int reverse3(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
    char[] arr = str.trim().toCharArray();
    StringBuffer res = new StringBuffer();
    for(int i=0; i<arr.length;i++){
        if()
    }
}
