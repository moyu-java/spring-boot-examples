package com.junmoyu.example.api.doc.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 文章信息响应对象
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 5595567275902507269L;

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
     * 评论列表
     */
    private List<String> comments;
}
