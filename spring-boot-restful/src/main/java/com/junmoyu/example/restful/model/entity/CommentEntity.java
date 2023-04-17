package com.junmoyu.example.restful.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 评论实体类
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
public class CommentEntity {

    /**
     * 评论ID - 主键
     */
    private Long id;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 评论人
     */
    private String publisher;

    /**
     * 创建时间/评论时间
     */
    private Date createTime;

    /**
     * 评论内容
     */
    private String content;
}
