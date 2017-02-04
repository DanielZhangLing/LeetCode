package ImplementTrie208;

class TrieNode{
    public char value;
    public boolean isWord;
    public TrieNode[] son = new TrieNode[26];
    public TrieNode(){};
    public TrieNode(char value){
        this.value = value;
    }
}

public class ImplementTrie {

    public TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(int i =0; i<word.length();i++){
            char temp = word.charAt(i);
            if(root.son[temp-'a']==null)
                root.son[temp-'a'] = new TrieNode(temp);
            current = current.son[temp-'a'];
        }
        current.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(int i =0; i<word.length();i++){
            char temp = word.charAt(i);
            if(root.son[temp-'a']==null)
                return false;
            current = current.son[temp-'a'];
        }
        return current.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i =0; i<prefix.length();i++){
            char temp = prefix.charAt(i);
            if(root.son[temp-'a']==null)
                return false;
            current = current.son[temp-'a'];
        }
        return true;
    }
    public static void main(String[] args){
    	ImplementTrie obj = new ImplementTrie();
    	  obj.insert("ab");
    	  boolean param_2 = obj.search("a");
    	  boolean param_3 = obj.startsWith("a");
    	  System.out.println(param_2);;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
