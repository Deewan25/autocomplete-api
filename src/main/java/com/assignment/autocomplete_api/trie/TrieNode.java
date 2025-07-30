package com.assignment.autocomplete_api.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    List<String> suggestions = new ArrayList<>();
    boolean isEndOfWord;
}
