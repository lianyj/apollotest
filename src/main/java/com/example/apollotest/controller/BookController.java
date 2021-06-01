package com.example.apollotest.controller;

import com.example.apollotest.config.ApplicationConfig;
import com.example.apollotest.entity.Book;
import com.example.apollotest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName BookController
 * Description
 * Create by yanjie14
 * Date 2021/5/31 10:42 上午
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private ApplicationConfig applicationConfig;



    @GetMapping("/getUser")
    public String getUser(){
        return applicationConfig.getName() +":"+applicationConfig.getAge();
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookService.findAll();
    }


}
