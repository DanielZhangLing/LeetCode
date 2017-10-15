package ImplementTrie208;

public class ImplementTrie {

    char val;
    Trie[] t;
    boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        t = new Trie[26];
        val = ' ';
    }
    
    public Trie(char c) {
        t = new Trie[26];
        val = c;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for(char c: word.toCharArray()){
            if(cur.t[c-'a']==null){
                cur.t[c-'a'] = new Trie(c);
            }
            cur = cur.t[c-'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for(char c: word.toCharArray()){
            if(cur.t[c-'a']==null){
                return false;
            }
            cur = cur.t[c-'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(char c: prefix.toCharArray()){
            if(cur.t[c-'a']==null){
                return false;
            }
            cur = cur.t[c-'a'];
        }
        if(cur.isWord){
            return true;
        }
        for(Trie elm: cur.t){
            if (elm!=null)
                return true;
        }
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
