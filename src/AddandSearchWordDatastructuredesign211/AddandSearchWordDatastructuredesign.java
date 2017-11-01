package AddandSearchWordDatastructuredesign211;

class WordDictionary {

    WordDictionary[] dicts;
    boolean isWord;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        dicts = new WordDictionary[26];
        isWord = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary cur = this;
        for(int i = 0 ; i<word.length(); i++){
            int c = word.charAt(i)-'a';
            if(null==cur.dicts[c]){
                cur.dicts[c] = new WordDictionary();
            }
            cur = cur.dicts[c];
            if(i == word.length()-1)
                cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	//dfs
        return search(word.toCharArray(), 0, this);
    }
    
    private boolean search(char[] word, int index, WordDictionary wd){
    	// check final case meet the end, remember is length() actually index is one step ahead of wd
        if(index ==word.length){
            return wd.isWord;
        }
        char c = word[index];
        if(word[index]=='.'){
            for(int i = 0; i<26; i++){
                if(wd.dicts[i]!=null&&search(word, index+1, wd.dicts[i])){
                    return true;
                }
            }
            return false;
        }else{
           if(wd.dicts[c-'a']==null)
               return false;
        }    
        return search(word, index+1, wd.dicts[c-'a']);
    }
}






class TrieNode{
    char value;
    boolean isWord;
    TrieNode[] son = new TrieNode[26];
    public TrieNode(){};
    public TrieNode(char c){
        this.value = c;
    }
}

public class AddandSearchWordDatastructuredesign {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public AddandSearchWordDatastructuredesign() {
        root = new TrieNode(' ');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i<word.length();i++){
            char temp = word.charAt(i);
            if(current.son[temp-'a']==null)
                current.son[temp-'a'] = new TrieNode(temp);
            current = current.son[temp-'a'];
        }
        current.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return subSearch(word, root);
    }
    public boolean subSearch(String word, TrieNode node){
        boolean result = false;
        for(int i = 0; i<word.length();i++){
            char temp = word.charAt(i);
            if(temp == '.'){
                for(int j = 0; j<26;j++){
                    if(node.son[j]!=null){
                        result = result || subSearch(word.substring(1+i) ,node.son[j]);
                    }
                }
                return result;
            }
            else if(node.son[temp-'a']==null)
                return false;
            else node = node.son[temp-'a'];
            
        }
        return result;
    }
    
    public static void main(String[] args){
    	AddandSearchWordDatastructuredesign obj = new AddandSearchWordDatastructuredesign();
    	  obj.addWord("bad");
    	  obj.addWord("dad");
    	  obj.addWord("mad");
    	  obj.search("pad");
    	  obj.search("bad");
    	  obj.search(".ad");
    	  obj.search("b..");
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */