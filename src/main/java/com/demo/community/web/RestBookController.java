package com.demo.community.web;

import com.demo.community.domain.Book;
import com.demo.community.repository.BookRepository;
import com.demo.community.service.BookRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestBookController {
    private final BookRestService bookRestService;

    @GetMapping(path="/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getRestBooks() {
        return bookRestService.getRestBook();
    }
}
