package com.junmoyu.example.api.doc.controller;

import com.junmoyu.example.api.doc.model.base.PageResult;
import com.junmoyu.example.api.doc.model.base.Response;
import com.junmoyu.example.api.doc.model.request.ArticleCreateRequest;
import com.junmoyu.example.api.doc.model.request.ArticlePageRequest;
import com.junmoyu.example.api.doc.model.request.ArticleUpdateRequest;
import com.junmoyu.example.api.doc.model.response.ArticleResponse;
import com.junmoyu.example.api.doc.model.response.CommentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章操作接口层
 * 主要用于接口定义，参数校验，权限认证，无业务逻辑
 *
 * @author 莫语
 * @date 2023/4/16
 */
@RestController
@RequestMapping("articles")
@Tag(name = "文章管理")
public class ArticleController {

    /**
     * 获取文章分页列表
     *
     * @return 文章分页列表
     */
    @GetMapping("")
    @Operation(summary = "获取文章分页列表")
    public Response<PageResult<ArticleResponse>> listArticle(@ParameterObject ArticlePageRequest pageRequest) {
        return null;
    }

    /**
     * 根据文章 ID 获取文章详细信息
     *
     * @param id 文章 ID
     * @return 文章详情
     */
    @GetMapping("{id}")
    @Operation(summary = "获取文章详情")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "业务ID主键", required = true)
    public Response<ArticleResponse> getArticle(@PathVariable Long id) {
        return null;
    }

    /**
     * 获取某篇文章下的评论列表
     *
     * @param id 文章 ID
     * @return 评论列表
     */
    @GetMapping("{id}/comments")
    @Operation(summary = "获取某篇文章下的评论列表")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "业务ID主键", required = true)
    public Response<List<CommentResponse>> listArticleComment(@PathVariable Long id) {
        return null;
    }

    /**
     * 创建新文章
     *
     * @param createRequest 请求参数
     * @return 新文章的ID
     */
    @PostMapping()
    @Operation(summary = "创建新文章")
    public Response<Long> createArticle(@RequestBody ArticleCreateRequest createRequest) {
        return null;
    }

    /**
     * 更新文章信息
     *
     * @param id            文章ID
     * @param updateRequest 请求参数
     * @return 更新结果
     */
    @PutMapping("{id}")
    @Operation(summary = "更新文章信息")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "业务ID主键", required = true)
    public Response<Boolean> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateRequest updateRequest) {
        return null;
    }

    /**
     * 删除文章
     *
     * @param id 文章ID
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    @Operation(summary = "删除文章")
    @Parameter(name = "id", in = ParameterIn.PATH, description = "业务ID主键", required = true)
    public Response<Boolean> deleteArticle(@PathVariable Long id) {
        return null;
    }
}
