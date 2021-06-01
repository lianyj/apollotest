package com.example.apollotest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.apollotest.entity.Book;
import com.example.apollotest.mapper.BookMapper;
import com.example.apollotest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName BookServiceImpl
 * Description
 * Create by yanjie14
 * Date 2021/5/31 10:39 上午
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public List<Book> findAll() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<Book>();
        return bookMapper.selectList(wrapper);
    }
}
