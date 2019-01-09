package problem11;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {

    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;
    ArrayList<String> phrase;

    public TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
        phrase = new ArrayList<>();
    }

}
