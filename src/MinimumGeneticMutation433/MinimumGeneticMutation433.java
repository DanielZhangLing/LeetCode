package MinimumGeneticMutation433;

public class MinimumGeneticMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        for(String s: bank){
            set.add(s);
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int level = -1;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0 ; i <size; i++){
                String cur = q.poll();
                if(end.equals(cur))
                    return level;
                else{
                    char[] charArray = cur.toCharArray();
                    for(int j = 0 ; j<charArray.length; j++){
                        char old = charArray[j];
                        for(char c: charSet){
                            charArray[j] = c;
                            String next = new String(charArray);
                            if(!visited.contains(next)&&set.contains(next)){
                                visited.add(next);
                                q.add(next);
                            }
                            charArray[j] = old;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
