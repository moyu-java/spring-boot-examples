package com.junmoyu.example.restful.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 文章实体类
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
public class ArticleEntity {

    /**
     * 文章ID - 主键
     */
    private Long id;

    /**
     * 文章名称
     */
    private String name;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
