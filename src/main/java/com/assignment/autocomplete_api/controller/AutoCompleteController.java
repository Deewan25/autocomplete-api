package com.assignment.autocomplete_api.controller;

import com.assignment.autocomplete_api.service.TrieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/autocomplete/v1")
public class AutoCompleteController {

    private final TrieService trieService;

    @Autowired
    public AutoCompleteController(TrieService trieService) {
        this.trieService = trieService;
    }

    @GetMapping("/suggest")
    public ResponseEntity<?> getSuggestions(@RequestParam String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                            "error", "Prefix cannot be empty",
                            "status", HttpStatus.BAD_REQUEST.value(),
                            "timestamp", Instant.now().toString()
                    ));
        }

        List<String> suggestions = trieService.getSuggestions(prefix);

        if (suggestions.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of(
                            "error", "No names found matching the prefix",
                            "status", HttpStatus.NOT_FOUND.value(),
                            "prefix", prefix,
                            "timestamp", Instant.now().toString()
                    ));
        }

        return ResponseEntity.ok(Map.of(
                "prefix", prefix,
                "matches", suggestions,
                "count", suggestions.size()
        ));
    }
}