package com.junmoyu.example.api.doc.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论响应对象
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 9008335791614410529L;

    /**
     * 评论ID - 主键
     */
    private Long id;

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
