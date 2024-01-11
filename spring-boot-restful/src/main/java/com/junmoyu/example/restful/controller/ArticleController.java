package com.junmoyu.example.restful.controller;

import com.junmoyu.example.restful.model.base.PageResult;
import com.junmoyu.example.restful.model.base.Response;
import com.junmoyu.example.restful.model.request.ArticleCreateRequest;
import com.junmoyu.example.restful.model.request.ArticlePageRequest;
import com.junmoyu.example.restful.model.request.ArticleUpdateRequest;
import com.junmoyu.example.restful.model.response.ArticleResponse;
import com.junmoyu.example.restful.model.response.CommentResponse;
import com.junmoyu.example.restful.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章操作接口层
 * 主要用于接口定义，参数校验，权限认证，无业务逻辑
 *
 * @author 莫语
 */
@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    /**
     * 获取文章分页列表
     *
     * @return 文章分页列表
     */
    @GetMapping("")
    public Response<PageResult<ArticleResponse>> listArticle(ArticlePageRequest pageRequest) {
        return Response.success(articleService.listArticle(pageRequest));
    }

    /**
     * 根据文章 ID 获取文章详细信息
     *
     * @param id 文章 ID
     * @return 文章详情
     */
    @GetMapping("{id}")
    public Response<ArticleResponse> getArticle(@PathVariable Long id) {
        return Response.success(articleService.getArticleDetail(id));
    }

    /**
     * 获取某篇文章下的评论列表
     *
     * @param id 文章 ID
     * @return 评论列表
     */
    @GetMapping("{id}/comments")
    public Response<List<CommentResponse>> listArticleComment(@PathVariable Long id) {
        return Response.success(articleService.listComment(id));
    }

    /**
     * 创建新文章
     *
     * @param createRequest 请求参数
     * @return 新文章的ID
     */
    @PostMapping()
    public Response<Long> createArticle(@RequestBody @Valid ArticleCreateRequest createRequest) {
        return Response.success(articleService.createArticle(createRequest));
    }

    /**
     * 更新文章信息
     *
     * @param id            文章ID
     * @param updateRequest 请求参数
     * @return 更新结果
     */
    @PutMapping("{id}")
    public Response<Boolean> updateArticle(@PathVariable Long id, @RequestBody @Valid ArticleUpdateRequest updateRequest) {
        updateRequest.setId(id);
        articleService.updateArticle(updateRequest);
        return Response.success(true);
    }

    /**
     * 删除文章
     *
     * @param id 文章ID
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    public Response<Boolean> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return Response.success(true);
    }
}
