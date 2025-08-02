package com.assignment.autocomplete_api.trie;

import java.util.Set;

public class Trie {
    private final TrieNode root = new TrieNode();

    /**
     * Inserts the entire word into the Trie data structure.
     * And caches each word at character level and stores in the set.
     *
     * Time Complexity: O(L) where L is the length of the word.
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toLowerCase().toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.suggestions.add(word);
        }
        node.isEndOfWord = true;
    }

    /**
     * Returns all the matching prefix's word found in the Trie data structure.
     *
     * Time Complexity: O(K) where K is the length of the prefix.
     * @param prefix
     * @return
     */
    public Set<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(c);
            if (node == null) return Set.of();
        }
        return node.suggestions;
    }
}
