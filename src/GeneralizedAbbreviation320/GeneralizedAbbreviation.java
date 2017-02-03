package GeneralizedAbbreviation320;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

	public List<String> generateAbbreviations(String word) {

		ArrayList<String> res = new ArrayList<String>();
		res.add(word);
		if (word == null || word.length() < 1)
			return res;
//		if (word.length() == 1) {
//			res.add(word);
//			res.add("1");
//			return res;
//		}
		int len = word.length();
		for (int i = 1; i <= len; i++)
			for (int j = 0; j < len - i + 1; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(word.substring(0, j)).append(i);
				String tempS = sb.toString();
				// sb.append(word.substring(0,j)).append(i).append(word.substring(j+i,len));
				//res.add(tempS + word.substring(j + i, len));
				List<String> temp = j + i + 1 <= len ? generateAbbreviations(word.substring(j + i + 1, len)) : null;
				if (temp!=null&&!temp.isEmpty())
					for (String s : temp) {
						res.add(tempS + word.substring(j + i, j + i + 1) + s);
					}
				
				else res.add(tempS + word.substring(j + i, len));
			}
		return res;
	}

}
