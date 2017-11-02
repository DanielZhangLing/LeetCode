package ImplementTrie208;

public class ImplementTrie {
    private Trie[] words;
    private boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        words = new Trie[26];
        isWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for(int i = 0; i <word.length(); i ++){
            char c = word.charAt(i);
            Trie next = cur.words[c-'a'];
            if(next==null){
                next = new Trie();// check  
                cur.words[c-'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for(int i = 0; i <word.length(); i ++){
            char c = word.charAt(i);
            Trie next = cur.words[c-'a'];
            if(next==null){
               return false;// check   
            }
            cur = next;
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(int i = 0; i <prefix.length(); i ++){
            char c = prefix.charAt(i);
            Trie next = cur.words[c-'a'];
            if(i == prefix.length()-1)
                return next!=null;
            if(next==null){
               return false;// check   
            }
            cur = next;
        }
        // for(int i = 0; i<26; i++){
        //     if(cur.words[i]!=null)
        //         return true;
        // }
        // return false;  
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
