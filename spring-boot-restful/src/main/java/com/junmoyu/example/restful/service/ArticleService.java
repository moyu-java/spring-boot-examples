package com.junmoyu.example.restful.service;

import com.junmoyu.example.restful.repository.ArticleRepository;
import com.junmoyu.example.restful.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑层，用来组合多种数据实体，转换为前端所需要的数据结构
 *
 * @author 莫语
 * @date 2023/2/27
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final CommentRepository commentRepository;

    public Object getArticleDetail(Long articleId) {
        return null;
    }

}
