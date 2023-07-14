-- 数据库初始化 SQL 脚本
-- 创建文章表
CREATE TABLE IF NOT EXISTS `article`
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '业务主键ID',
    name    VARCHAR(100) COMMENT '文章名',
    author  VARCHAR(100) COMMENT '文章作者',
    content TEXT COMMENT '文章内容',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);
-- 创建文章表
CREATE TABLE IF NOT EXISTS `comment`
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '业务主键ID',
    article_id  BIGINT COMMENT '文章ID',
    publisher   VARCHAR(20) COMMENT '评论人',
    content     VARCHAR(2048) COMMENT '评论内容',
    create_time DATETIME COMMENT '创建时间'
);

-- 插入示例数据
INSERT INTO `article` (id, name, author, content, create_time, update_time)
VALUES (1, '博客1', '作者1', '测试博客内容1', '2023-04-01 11:01:01', '2023-04-01 11:01:01'),
       (2, '博客2', '作者2', '测试博客内容2', '2023-04-01 11:01:02', '2023-04-01 11:01:02'),
       (3, '博客3', '作者3', '测试博客内容3', '2023-04-01 11:01:04', '2023-04-01 11:01:03');

INSERT INTO `comment` (article_id, publisher, content, create_time)
VALUES (1, '小明', '评论1', '2023-04-01 12:01:01'),
       (1, '小花', '评论2', '2023-04-01 12:01:02'),
       (1, '小李', '评论3', '2023-04-01 12:01:03');