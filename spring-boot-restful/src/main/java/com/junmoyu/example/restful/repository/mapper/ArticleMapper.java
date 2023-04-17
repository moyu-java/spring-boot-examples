package com.junmoyu.example.restful.repository.mapper;

import com.junmoyu.example.restful.model.entity.ArticleEntity;
import com.junmoyu.example.restful.model.request.ArticlePageRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 文章数据操作接口
 *
 * @author 莫语
 * @date 2023/4/14
 */
@Mapper
public interface ArticleMapper {

    @Select("""
            <script>
            select count(*) from article
            <if test='name != null and name != ""'>where name like CONCAT('%', #{name,jdbcType=VARCHAR}, '%')</if>
            </script>
            """)
    int count(ArticlePageRequest pageRequest);

    @Select("""
            <script>
            select * from article
            <if test='name != null and name != ""'>where name like CONCAT('%', #{name,jdbcType=VARCHAR}, '%')</if>
            limit ${offset}, ${pageSize}
            </script>
            """)
    List<ArticleEntity> selectList(ArticlePageRequest pageRequest);

    @Select("select * from article where id = #{id,jdbcType=BIGINT}")
    ArticleEntity selectById(Long id);

    @Insert("""
            insert into article (name, author, content, create_time, update_time)
            VALUES(#{name,jdbcType=VARCHAR}, #{author,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR},
            #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ArticleEntity articleEntity);

    @Update("""
            update article set name = #{name,jdbcType=VARCHAR}, author = #{author,jdbcType=VARCHAR},
            content = #{content,jdbcType=LONGVARCHAR}, update_time = #{updateTime,jdbcType=TIMESTAMP}
            where id = #{id,jdbcType=BIGINT}
            """)
    int update(ArticleEntity articleEntity);

    @Delete("delete from article where id = #{id,jdbcType=BIGINT}")
    void delete(Long id);
}
