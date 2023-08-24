package com.example.urlshortener.services.impl;

import com.example.urlshortener.data.models.Link;
import com.example.urlshortener.data.repositories.LinkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class LinkServiceImplTest {
    LinkServiceImpl linkService;
    LinkRepository linkRepository;
    @Autowired
    LinkServiceImplTest(LinkRepository linkRepository, LinkServiceImpl linkService){
        this.linkService = linkService;
        this.linkRepository = linkRepository;
    }

    @Test
    public void testRepository(){
        Link link = new Link();
        Link savedLink = linkRepository.save(link);
        assertNotNull(savedLink);
    }
    @Test
    void shorten() {
        String url = "https://gitea.com/moonshon/khambo1/raw/branch/main/New_Active_Setup.txt";
        String result = linkService.shorten(url);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    void getLongUrl() {
        String longUrl = "https://gitea.com/moonshon/khambo1/raw/branch/main/New_Active_Setup.txt";
        String shortUrl = "yix_nmpd";
        String result = linkService.getLongUrl(shortUrl);
        System.out.println(result);
        assertEquals(longUrl, result);
    }

    @Test
    void deleteShortUrl() {

    }

    @Test
    void getAllLinks() {
        Link link = new Link();
        linkRepository.save(link);Link link1 = new Link();
        linkRepository.save(link1);Link link2 = new Link();
        linkRepository.save(link2);Link link3 = new Link();
        linkRepository.save(link3);
        assertNotNull(linkRepository.findAll());
    }
}