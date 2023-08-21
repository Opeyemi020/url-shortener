package com.example.urlshortener.controllers;

import com.example.urlshortener.services.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/link")
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestBody CreateShortUrlRequest request){
        CreateShortUrlResponse response = linkService.shorten(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
