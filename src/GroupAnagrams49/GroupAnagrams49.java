package GroupAnagrams49;

public class GroupAnagrams49 {
	/*
	 * sor all the string and use a hashmap to add all the string
	 * which has the same character into a value
	 */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            if(!map.containsKey(key)){
                List<String> ls = new ArrayList<>();
                ls.add(s);
                map.put(key,ls);
            }else{
                map.get(key).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    
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
