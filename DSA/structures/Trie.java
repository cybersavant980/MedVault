package DSA.structures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    // =====================================================
    // Trie Node
    // =====================================================

    protected static class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    // =====================================================
    // Root Node
    // =====================================================

    protected final TrieNode root;

    // =====================================================
    // Constructor
    // =====================================================

    public Trie() {
        root = new TrieNode();
    }

    // =====================================================
    // Insert Word
    // =====================================================

    public void insert(String word) {

        if (word == null || word.isBlank())
            return;

        TrieNode current = root;

        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {

            current.children.putIfAbsent(ch, new TrieNode());

            current = current.children.get(ch);
        }

        current.endOfWord = true;
    }

    // =====================================================
    // Search Exact Word
    // =====================================================

    public boolean search(String word) {

        if (word == null || word.isBlank())
            return false;

        TrieNode current = root;

        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {

            if (!current.children.containsKey(ch))
                return false;

            current = current.children.get(ch);
        }

        return current.endOfWord;
    }

    // =====================================================
    // Prefix Search
    // =====================================================

    public boolean startsWith(String prefix) {

        if (prefix == null || prefix.isBlank())
            return false;

        TrieNode current = root;

        prefix = prefix.toLowerCase();

        for (char ch : prefix.toCharArray()) {

            if (!current.children.containsKey(ch))
                return false;

            current = current.children.get(ch);
        }

        return true;
    }

    // =====================================================
    // Clear Trie
    // =====================================================

    public void clear() {
        root.children.clear();
    }

}