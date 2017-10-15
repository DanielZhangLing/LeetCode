package WordLadder127;

public class WordLadder127 {
	/*
	 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
Only one letter can be changed at a time Each intermediate word must exist in the word list For example,
Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log"] As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.




求最短路径一般是用BFS的方法，这里就是不断的BFS搜查当前word的neighbours（在wordList里的)， 如果遍历字典里的 所有word，那么会随着字典的变大而时间复杂度太大，我们可以用26个字母去替换，就得到固定的时间复杂度。
注意点

一开始要将endWord加入到wordList里，这样最后达到的时候好判断
只要已经是endWord了就可以立刻返回，因为只要求最小的长度，BFS最先得到的必然是最小长度
BFS将neighbours加入到queue之后要将它们从wordList中删去，不然会得到重复的loop
List删除一个元素后，比如现在List = {a, b, c, d} 删除c以后，成为{a, b, , d}， 要把c后面的元素都向前移动一位才能成为{a,b,d}。
所以这里的remove操作时间复杂度是O(list.size())，才会出现TLE。你所有的算法都对，只需要把List改成Set即可。

	 */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||beginWord.equals(endWord))
            return 0;
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }

        Queue<String> q = new LinkedList<String>();
        int level = 1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0; i<size; i++){
                String temp = q.poll();
                for(String elm: findNeighbour(temp,dict)){
                    if(elm.equals(endWord))
                        return level;
                    else{
                        q.add(elm);
                    }
                }
            }
        }
        return 0;
    }
    
    public Set<String> findNeighbour(String array, Set<String> set){
        Set<String> res = new HashSet<String>();
        for(int i = 0; i < array.length() ; i++){
            for(char c='a';c<='z';c++){
                char[] ch = array.toCharArray();
                ch[i] = c;
                String temp = new String(ch);
                // String temp = array.substring(0,i)+c+array.substring(i+1, array.length());
                if(!temp.equals(array)&&set.contains(temp)){
                    set.remove(temp);
                    res.add(temp);
                }
                    
            }
        }
        return res;
    }
}
