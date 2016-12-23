package AddDigits258;
public class AddDigit {
	
	public static int add (int num){
		if (num<10 )
			return num;
		int temp = 0;
		while( num != 0){
			temp += num%10;
			num /= 10;
		}
		return add(temp);
	}
	
	public static int add2 (int num){
		if (num<10 )
			return num;
		while(num>=10){
			int temp = 0;
			while( num != 0){
				temp += num%10;
				num /= 10;
			}
			num = temp;		
		}

		return num;
	}
	
    public int add3(int num) {

        return num==0?0:(num%9==0?9:(num%9));

    }
	public static void main(String [ ] args) {
		System.out.println ( add2(10) );
	}
}
