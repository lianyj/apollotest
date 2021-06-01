package com.example.apollotest.service;

import com.example.apollotest.entity.Book;

import java.util.List;

/**
 * ClassName BookService
 * Description
 * Create by yanjie14
 * Date 2021/5/27 8:48 下午
 */
public interface BookService {

    List<Book> findAll();
}
