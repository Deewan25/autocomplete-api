package com.assignment.autocomplete_api.service;

import com.assignment.autocomplete_api.repository.NameRepository;
import com.assignment.autocomplete_api.trie.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TrieService {
    private final Trie trie = new Trie();

    /**
     * Loads all the names present in the Name table into Trie data structure.
     * @param repository
     */
    @Autowired
    public TrieService(NameRepository repository) {
        repository.findAll().forEach(name -> trie.insert(name.getValue()));
    }

    public Set<String> getSuggestions(String prefix) {
        return trie.autocomplete(prefix);
    }
}
