package com.example.movie.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MovieController {

    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test() {
        String a = "abc";
        return ResponseEntity.ok(a);
    }
}
