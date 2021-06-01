package com.example.apollotest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName Book
 * Description
 * Create by yanjie14
 * Date 2021/5/27 8:42 下午
 */
@Data
public class Book {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private BigDecimal price;
    private Integer bookcaseid;
    private Integer abled;


}
