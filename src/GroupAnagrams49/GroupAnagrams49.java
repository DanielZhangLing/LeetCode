package GroupAnagrams49;

public class GroupAnagrams49 {
	/*
	 * sor all the string and use a hashmap to add all the string
	 * which has the same character into a value
	 */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            String tmp = new String(cur);
            if(map.get(tmp)==null){
                List<String> sList = new ArrayList<>();
                sList.add(str);
                map.put(tmp,sList);
            }else{
                map.get(tmp).add(str);
            }
        }
        for(List<String> sList: map.values()){
            res.add(sList);
        }
        return res;
    }
}
