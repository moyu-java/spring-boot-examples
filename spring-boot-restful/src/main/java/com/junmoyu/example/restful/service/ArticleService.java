package com.junmoyu.example.restful.service;

import com.junmoyu.example.restful.model.base.PageResult;
import com.junmoyu.example.restful.model.entity.ArticleEntity;
import com.junmoyu.example.restful.model.entity.CommentEntity;
import com.junmoyu.example.restful.model.request.ArticleCreateRequest;
import com.junmoyu.example.restful.model.request.ArticlePageRequest;
import com.junmoyu.example.restful.model.request.ArticleUpdateRequest;
import com.junmoyu.example.restful.model.response.ArticleResponse;
import com.junmoyu.example.restful.model.response.CommentResponse;
import com.junmoyu.example.restful.repository.ArticleRepository;
import com.junmoyu.example.restful.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑层，用来组合多种数据实体，转换为前端所需要的数据结构
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final CommentRepository commentRepository;

    /**
     * 获取文章的分页列表
     *
     * @param pageRequest 分页请求参数
     * @return 分页列表信息
     */
    public PageResult<ArticleResponse> listArticle(ArticlePageRequest pageRequest) {
        PageResult<ArticleEntity> articleEntityPageResult = articleRepository.listArticle(pageRequest);
        if (articleEntityPageResult.isEmpty()) {
            return new PageResult<>(0);
        }
        List<ArticleResponse> articleResponses = articleEntityPageResult.getList().stream().map(this::convertArticle).toList();
        return new PageResult<>(articleEntityPageResult.getTotal(), articleResponses);
    }

    /**
     * 根据文章 ID 获取文章详细信息（包含评论）
     *
     * @param articleId 文章 ID
     * @return 文章详情
     */
    public ArticleResponse getArticleDetail(Long articleId) {
        // 获取文章信息
        ArticleEntity article = articleRepository.getArticle(articleId);
        if (article == null) {
            throw new RuntimeException("文章不存在");
        }
        // 获取评论信息
        List<String> comments = commentRepository.listCommentContent(articleId);
        // 组合多个实体数据并返回响应数据
        return ArticleResponse.builder()
                .id(article.getId())
                .name(article.getName())
                .author(article.getAuthor())
                .content(article.getContent())
                .comments(comments)
                .build();
    }

    public Long createArticle(ArticleCreateRequest createRequest) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setName(createRequest.getName());
        articleEntity.setAuthor(createRequest.getAuthor());
        articleEntity.setContent(createRequest.getContent());
        return articleRepository.createArticle(articleEntity);
    }

    public void updateArticle(ArticleUpdateRequest updateRequest) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(updateRequest.getId());
        articleEntity.setName(updateRequest.getName());
        articleEntity.setAuthor(updateRequest.getAuthor());
        articleEntity.setContent(updateRequest.getContent());
        articleRepository.updateArticle(articleEntity);
    }

    public void deleteArticle(Long id) {
        // 很多企业实际的业务应该是逻辑删除
        articleRepository.deleteArticle(id);
    }

    public List<CommentResponse> listComment(Long articleId) {
        List<CommentEntity> commentEntities = commentRepository.listComment(articleId);
        return commentEntities.stream().map(this::convertComment).toList();
    }

    /**
     * 实体转换
     * 建议使用 <a href="https://mapstruct.org">MapStruct</a> 进行实体转换
     *
     * @param articleEntity 文章实体类
     * @return 文章响应对象类
     */
    private ArticleResponse convertArticle(ArticleEntity articleEntity) {
        return ArticleResponse.builder()
                .id(articleEntity.getId())
                .name(articleEntity.getName())
                .author(articleEntity.getAuthor())
                .content(articleEntity.getContent())
                .build();
    }

    private CommentResponse convertComment(CommentEntity commentEntity) {
        return CommentResponse.builder()
                .id(commentEntity.getId())
                .publisher(commentEntity.getPublisher())
                .content(commentEntity.getContent())
                .createTime(commentEntity.getCreateTime())
                .build();
    }
}
