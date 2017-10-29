import java.util.*;
class TrieNode {
    int count;
    SortedMap<Character, TrieNode> childNodes;

    public TrieNode(int count){
        this.count = count;
        this.childNodes = new TreeMap<Character, TrieNode>();
    }
}
public class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode(0);
    }

    public void insertTrie(String word) {
        SortedMap<Character, TrieNode> nextLetters = root.childNodes;

        // all but the last letter in the word
        for ( int i = 0, n = word.length() - 1; i < n; ++i ) {
            char letter = word.charAt(i);

            if ( ! nextLetters.containsKey(letter) ) {
                nextLetters.put(letter, new TrieNode(0));
            }

            nextLetters = nextLetters.get(letter).childNodes;
        }

        // the last letter, so set or update count appropriately
        char letter = word.charAt(word.length() - 1);
        TrieNode node = nextLetters.get(letter);
        if ( null == node ) {
            nextLetters.put(letter, new TrieNode(1));
        } else {
            node.count++;
        }
    }

    public boolean searchTrie(String word) {
        SortedMap<Character, TrieNode> nextLetters;
        TrieNode node = root;

        for ( Character letter : word.toCharArray() ) {
            nextLetters = node.childNodes;
            node = nextLetters.get(letter);

            if ( node == null ) {
                return false;
            }
        }

        return node.count > 0;
    }

public static void main(String[] args) {
        String[] words = {"How to use something!", "bid","bid", "stock", "spock", "sell", "shell"};

        Trie trie = new Trie();
        for ( String word : words ) {
        trie.insertTrie(word);
        }

        System.out.println(trie.searchTrie("How to use something!"));
        System.out.println(trie.searchTrie("bid"));
        System.out.println(trie.searchTrie("bide"));
        System.out.println(trie.searchTrie("shelf"));
        System.out.println(trie.searchTrie("shell"));
        }
}