# 简介
> spring-boot-projectx 是一个基于Spring Boot搭建的简洁的项目模板，该项目模板已集成了常用的技术组件，
> 用户基于该模板可以快速搭建自己的WEB/API项目。

# 项目结构
该项目模板是多模块项目，使用者可根据需要调整。
+ demo-api     ： 接口层，比如内部的RPC接口
+ demo-common  ： 公共方法层
+ demo-dal     ： 数据接入层
+ demo-biz     ： 业务处理层
+ demo-start   ： 启动层，包含配置项和controller


# 技术组件
+ Spring Boot
+ MyBatis
+ Druid
+ Groovy
+ Logback
+ Jackson
+ Lombok
+ Hibernate Validator

# 打包部署
打包开发环境
> mvn clean package -Dmaven.test.skip=true -P dev

打包测试环境
> mvn clean package -Dmaven.test.skip=true -P test

打包生产环境
> mvn clean package -Dmaven.test.skip=true -P prod