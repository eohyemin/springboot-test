package com.demo.community.service;

import com.demo.community.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> getBookList();
}
