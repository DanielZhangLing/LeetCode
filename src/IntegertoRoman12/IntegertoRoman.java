package IntegertoRoman12;

public class IntegertoRoman {
	public String intToRoman(int num) {
		StringBuilder res = new StringBuilder();
		int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		for(int i=0; i<value.length;i++)
			while(num>=value[i]){
				res.append(str[i]);
				num -= value[i];
			}
		return res.toString();
	}
}
