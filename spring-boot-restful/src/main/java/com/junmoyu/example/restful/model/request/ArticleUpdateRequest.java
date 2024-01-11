package com.junmoyu.example.restful.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 文章创建请求对象
 *
 * @author 莫语
 */
@Data
public class ArticleUpdateRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -3339046283506502754L;

    private Long id;

    /**
     * 文章名称
     */
    @NotBlank(message = "文章名称不能为空")
    @Length(max = 20, message = "文章名称不能超过20个字符")
    private String name;

    /**
     * 文章作者
     */
    @NotBlank(message = "作者名称不能为空")
    private String author;

    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不能为空")
    private String content;
}
