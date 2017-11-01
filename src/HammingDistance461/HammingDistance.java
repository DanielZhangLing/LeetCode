package HammingDistance461;

public class HammingDistance {
    
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int res= 0;
        while(z!=0){
            res+= z&1;
            z = z>>1;
        }
        return res;
    }
    
	public static int hammingDistance(int x, int y) {
        
		int result = 0;
		int z = x^y;
		String bZ = Integer.toBinaryString(z);
		char[] cZ = bZ.toCharArray();
		for (int i=0; i<cZ.length;i++)
			if (cZ[i]=='1')
				result++;
		return result;
    }
	
	public static void main(String[] args){
		System.out.println(hammingDistance(1,4));
	}
}
