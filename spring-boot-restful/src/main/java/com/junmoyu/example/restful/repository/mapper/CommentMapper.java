package com.junmoyu.example.restful.repository.mapper;

import com.junmoyu.example.restful.model.entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 评论数据操作接口
 *
 * @author 莫语
 * @date 2023/4/14
 */
@Mapper
public interface CommentMapper {

    @Select("select * from `comment` where article_id = #{articleId,jdbcType=BIGINT} ")
    List<CommentEntity> listComment(Long articleId);
}
