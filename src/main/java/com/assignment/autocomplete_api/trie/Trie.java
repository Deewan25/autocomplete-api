package com.assignment.autocomplete_api.trie;

import java.util.List;

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toLowerCase().toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            if (!node.suggestions.contains(word)) {
                node.suggestions.add(word);
            }
        }
        node.isEndOfWord = true;
    }

    public List<String> autocomplete(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(c);
            if (node == null) return List.of();
        }
        return node.suggestions;
    }
}
