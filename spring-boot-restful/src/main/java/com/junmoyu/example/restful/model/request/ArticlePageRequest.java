package com.junmoyu.example.restful.model.request;

import com.junmoyu.example.restful.model.base.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;

/**
 * ArticlePageRequest
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ArticlePageRequest extends PageRequest {

    @Serial
    private static final long serialVersionUID = -4463651231910832856L;

    /**
     * 文章名称 - 模糊搜索
     */
    private String name;
}
