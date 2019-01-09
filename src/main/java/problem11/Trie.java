package problem11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Trie {

    TrieNode root;
    ArrayList<String> suggestList;

    public Trie(){
        root = new TrieNode();
        suggestList = new ArrayList<>();
    }

    public void insertInTrie(String word) {
        TrieNode current = root;
        TrieNode node;
        for(int i = 0; i < word.length(); i++){
            Character ch = word.charAt(i);
            current.phrase.add(word.substring(i));
            node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isEndOfWord = true;
    }

    public boolean searchEntireWord(String word){
        TrieNode current = root;
        TrieNode node;
        if(word.length() == 0){
            return false;
        }

        for(int i = 0; i < word.length(); i++){
            Character ch = word.charAt(i);
            node = current.children.get(ch);
            if(node == null){
                return false;
            }else{
                current = node;
            }
        }

        return ( current != null) && current.isEndOfWord;
    }

    public Set<String> findSuggestions(String word) {
        word = word.toLowerCase();
        TrieNode node = isPrefix(word);
        if (node == null){
            return new HashSet<>();
        }
        return findSuggestions(node, word);
    }

    private Set<String> findSuggestions(TrieNode node, String value) {
        Set<String> results = new HashSet<>();
        Iterator<Character> iterator = node.children.keySet().iterator();
        while(iterator.hasNext()) {
            Character character = iterator.next();
            if (node.children.get(character).isEndOfWord) {
                results.add(value+character+"");
            }
            results.addAll(findSuggestions(node.children.get(character), value+character+""));
        }
        return results;
    }


    private TrieNode isPrefix(String word) {
        return isPrefix(word, root);
    }

    private TrieNode isPrefix(String word, TrieNode node) {
        if (word.length() == 0)
            return null;
        if (node == null)
            return null;
        Character ch = word.charAt(0);

        if ( node.children.containsKey(ch)) {
            if (word.length() == 1) {
                return node.children.get(ch);
            }
            return isPrefix(word.substring(1), node.children.get(ch));
        }
        return null;

    }

    public static void main(String[] args) {
        Trie testTrie = new Trie();
        testTrie.insertInTrie("sudip");
        testTrie.insertInTrie("sudipta");
        testTrie.insertInTrie("sudipTam");
        System.out.println(testTrie.searchEntireWord("sudi"));
        final Set<String> set = testTrie.findSuggestions("su");
        if(set.isEmpty()){
            System.out.println("no matches found");
        }
        for(String str : set){
            System.out.println(str);
        }
    }


}
