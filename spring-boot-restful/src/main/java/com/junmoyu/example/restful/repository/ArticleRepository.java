package com.junmoyu.example.restful.repository;

import com.junmoyu.example.restful.model.base.PageResult;
import com.junmoyu.example.restful.model.entity.ArticleEntity;
import com.junmoyu.example.restful.model.request.ArticlePageRequest;
import com.junmoyu.example.restful.repository.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 数据仓库层 - 文章数据
 * 本层主要是用来连接数据源并操作数据
 * 数据源： MySQL、PostgreSQL、Redis、MongoDB、ElasticSearch、File
 *
 * @author 莫语
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final ArticleMapper articleMapper;

    public PageResult<ArticleEntity> listArticle(ArticlePageRequest pageRequest) {
        int count = articleMapper.count(pageRequest);
        if (count == 0) {
            return new PageResult<>(0);
        }
        List<ArticleEntity> articleEntities = articleMapper.selectList(pageRequest);
        return new PageResult<>(count, articleEntities);
    }

    /**
     * 根据文章 ID 获取文章信息
     * 某些企业可能会将文章信息存储在 MongoDB 或 ElasticSearch 中
     * 所以在 Service 和 Mapper 之间添加 Repository 层，屏蔽数据源细节
     *
     * @param id 文章 ID
     * @return 文章信息
     */
    public ArticleEntity getArticle(Long id) {
        return articleMapper.selectById(id);
    }

    public Long createArticle(ArticleEntity articleEntity) {
        // 封装部分需要系统生成或处理的数据
        articleEntity.setCreateTime(new Date());
        articleEntity.setUpdateTime(new Date());
        if (articleMapper.insert(articleEntity) > 0) {
            return articleEntity.getId();
        }
        throw new RuntimeException("文章创建失败");
    }

    public void updateArticle(ArticleEntity articleEntity) {
        if (articleEntity.getId() == null) {
            throw new RuntimeException("文章不存在");
        }
        if (articleMapper.update(articleEntity) == 0) {
            throw new RuntimeException("文章不存在");
        }
    }

    public void deleteArticle(Long id) {
        articleMapper.delete(id);
    }
}
