package ReconstructOriginalDigitsfromEnglish423;

import java.util.HashMap;

public class ReconstructOriginalDigitsfromEnglish {

//	public static String originalDigits(String s) {
//
//		StringBuilder sb = new StringBuilder();
//		int[] res = new int[10];
//		String[] digit = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
//		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int i = 0; i < s.length(); i++) {
//			char temp = s.charAt(i);
//			map.put(temp, map.getOrDefault(temp, 0) + 1);
//		}
//		for (int k = 0;k< digit.length;k++) {
//			boolean flag = true;
//			loop:while (flag == true) {
//			    			HashMap<Character, Integer> temp = new HashMap<Character,Integer>(map);
//				for (int i = 0; i < digit[k].length(); i++) {
//					char tempChar = digit[k].charAt(i);
//					if (map.get(tempChar)!=null&&map.get(tempChar) > 0)
//						map.put(tempChar, map.get(tempChar) - 1);
//					else {
//						map = temp;
//						flag = false;
//						break loop;
//					}
//
//				}
//									res[k]++;
//			}
//		}
//		
//		for(int i = 0; i<res.length;i++)
//			for(int j = 0;j<res[i];j++)
//				sb.append(i);
//		return sb.toString();
//			
//
//	}
	public static String originalDigits(String s) {
	    int[] count = new int[10];
	    for (int i = 0; i < s.length(); i++){
	        char c = s.charAt(i);
	        if (c == 'z') count[0]++;
	        if (c == 'w') count[2]++;
	        if (c == 'x') count[6]++;
	        if (c == 's') count[7]++; //7-6
	        if (c == 'g') count[8]++;
	        if (c == 'u') count[4]++; 
	        if (c == 'f') count[5]++; //5-4
	        if (c == 'h') count[3]++; //3-8
	        if (c == 'i') count[9]++; //9-8-5-6
	        if (c == 'o') count[1]++; //1-0-2-4
	    }
	    count[7] -= count[6];
	    count[5] -= count[4];
	    count[3] -= count[8];
	    count[9] = count[9] - count[8] - count[5] - count[6];
	    count[1] = count[1] - count[0] - count[2] - count[4];
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= 9; i++){
	        for (int j = 0; j < count[i]; j++){
	            sb.append(i);
	        }
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(originalDigits("zeroonetwothreefourfivesixseveneightnine"));
	}
}
