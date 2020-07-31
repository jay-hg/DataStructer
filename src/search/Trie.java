package search;

public class Trie {

    private boolean isWord;
    private char character;
    private Trie[] tries = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isWord = false;
        character = ' ';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie idx = this;
        char[] array = word.toCharArray();
        for (char c : array) {
            Trie node = idx.tries[c-'a'];
            if (node == null) {
                node = new Trie();
                node.character = c;
                idx.tries[c-'a'] = node;
            }
            idx = node;
        }
        idx.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie idx = this;
        char[] array = word.toCharArray();
        for (char c : array) {
            Trie node = idx.tries[c-'a'];
            if (node == null) {
                return false;
            }
            idx = node;
        }
        return idx.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie idx = this;
        char[] array = prefix.toCharArray();
        for (char c : array) {
            Trie node = idx.tries[c-'a'];
            if (node == null) {
                return false;
            }
            idx = node;
        }
        return true;
    }
}
