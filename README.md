这次应该能行了吧吗的不行吗,,,,,   
maven工程聚合分层说明:(可扩展 common层 utils层 ...)
    api:业务逻辑接口(暴露Dubbo接口)
    dao:数据访问层
    model:实体类
    rpc:Dubbo远程服务(Dubbo服务生产者)
    service:业务逻辑层的实现
    web:表现层(Dubbo Consumer1)
    job:定时任务(Dubbo Consumer2 )
                (Consumer消费者3.4.5......)


模块依赖关系:
    api
        model
    web(调用Dubbo服务需要注入api中的Dubbo接口)
       api
    rpc
       api
    service
        api
        dao
    dao
       api 

说明:
    springboot parent对构建springboot工程spring系列和一些常用的第三方包进行了管理。
    我们只需要将其作为parent即可不用指定版本号来引入spring和已经加入管理的第三方包。
    springboot这么做，也是为了解决第三方包之间的版本冲突问题。
            
项目启动流程:
    1.执行clean报错:
        解决:在父项目的pom.xml文件中 添加<packaging>pom</packaging>
    2.maven项目子项目依赖父项目，版本号无法继承 
        解决:父项目pom.xml文件中添加 <dependencyManagement>标签
    3.执行打包install报错 java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy
        :当天未解决,很受打击
    4.父项目加入新依赖 jar包不下载,
        :需要在子项目中添加依赖才能生效
        