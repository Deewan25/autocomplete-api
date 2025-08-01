package com.assignment.autocomplete_api.trie;

import java.util.*;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    Set<String> suggestions = new HashSet<>();
    boolean isEndOfWord;
}
