# Spring Boot 3.0 系列教程

Spring Boot 是一款用于简化 Java 应用程序开发和部署的框架，它提供了默认配置、内嵌容器、自动依赖管理、强大的监控管理等功能，使开发者能够更快速、更轻松地创建高效的应用程序。

2022年11月25日 Spring Boot 发布了 `3.0.0` 版本，本系列教程将为您带来最新的 Spring Boot 3.0 的开发与应用。

## Spring Boot 3.0 亮点

* 最低支持 Java 17，兼容 Java 19
* 支持使用 GraalVM 生成本机映像，取代实验性的Spring Native 项目
* 改进的 Micrometer 和 Micrometer Tracing 可观测性
* 最低支持 Jakarta EE 9，兼容 Jakarta EE 10

## 本教程版本说明

> - java: 17
> - spring boot: 3.0.5

## Spring Boot 基础入门

- [x] [Spring Boot Restful Web 服务构建](./spring-boot-restful)
- [ ] Spring Boot 工程结构
- [ ] Spring Boot 参数校验
- [ ] Jackson 集成配置

## 日志

- [x] [Spring Boot Logback 日志集成](./spring-boot-logback)
- [ ] Spring Boot Log4j2 日志集成

## RESTFUL API开发

- [ ] 创建 RESTFUL API
- [ ] 参数校验
- [ ] 跨域支持
- [ ] 文件上传

## 数据库集成

- [ ] 使用 Spring Boot 集成 redis
- [ ] 使用 MyBatis 访问数据库
- [ ] 配置多数据源
- [ ] 使用数据库连接池
- [ ] 配置事务管理

## 缓存和消息队列

- [ ] 使用 Spring Boot 集成 RabbitMQ
- [ ] 使用 Spring Boot 集成 Kafka
- [ ] 使用 Spring Boot 集成 ActiveMQ

## 安全

- [ ] 使用 Spring Security 配置安全认证
- [ ] 配置 HTTPS 和 SSL
- [ ] 配置 XSS 和 CSRF 防护
- [ ] 使用 JSON Web Token 实现认证和授权
- [ ] 使用 Spring Security OAuth2 实现授权服务器和资源服务器

## 测试

- [ ] 使用 JUnit 进行单元测试
- [ ] 使用 Mockito 进行单元测试
- [ ] 使用 Spring Boot Test 进行集成测试
- [ ] 使用 REST Assured 进行 API 测试
- [ ] 配置测试数据和测试环境

## 部署和监控

- [ ] 使用 Docker 部署 Spring Boot 应用
- [ ] 配置健康检查和自动重启
- [ ] 使用 Actuator 监控应用状态
- [ ] 配置应用日志和指标监控
- [ ] 使用 ELK Stack 实现日志分析和可视化监控