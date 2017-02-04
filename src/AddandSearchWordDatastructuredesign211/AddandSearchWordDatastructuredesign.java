package AddandSearchWordDatastructuredesign211;

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