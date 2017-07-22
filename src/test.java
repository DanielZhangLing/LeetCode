import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {
	
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||beginWord.equals(endWord))
            return 0;
        Queue<String> q = new LinkedList<String>();
        int level = 0;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i<size; i++){
                String temp = q.poll();
                for(String elm: findNeighbour(temp,wordList)){
                    if(elm.equals(endWord))
                        return level;
                    else{
                        wordList.remove(elm);
                        q.add(elm);
                    }
                }
            }
        }
        return 0;
    }
    
    public static List<String> findNeighbour(String array, List<String> wordList){
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < array.length() ; i++){
            for(char c='a';c<='z';c++){
                String temp = array.substring(0,i)+c+array.substring(i+1, array.length());
                if(!temp.equals(array)&&wordList.contains(temp))
                    res.add(temp);
            }
        }
        return res;
    }

	public static void main(String[] args){
		List<String> a = new ArrayList<String>();
		a.add("hot");
		a.add("dot");
		a.add("dog");
		a.add("lot");
		a.add("log");
		a.add("cog");
	
		System.out.println(ladderLength("hit","cog",a));
	}
}
