package com.junmoyu.example.restful.repository;

import com.junmoyu.example.restful.model.entity.CommentEntity;
import com.junmoyu.example.restful.repository.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据仓库层 - 评论数据
 *
 * @author 莫语
 * @date 2023/4/16
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final CommentMapper commentMapper;

    /**
     * 根据文章名称获取文章所属的评论内容列表
     *
     * @param articleId 文章 ID
     * @return 评论内容列表
     */
    public List<String> listCommentContent(Long articleId) {
        List<CommentEntity> commentEntities = listComment(articleId);
        return commentEntities.stream().map(CommentEntity::getContent).toList();
    }

    /**
     * 根据文章名称获取文章所属的评论列表
     *
     * @param articleId 文章 ID
     * @return 评论列表
     */
    public List<CommentEntity> listComment(Long articleId) {
        return commentMapper.listComment(articleId);
    }
}
