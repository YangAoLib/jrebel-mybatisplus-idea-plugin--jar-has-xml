# jrebel-mybatisplus-idea-plugin--jar-has-xml

使用JRebel热部署MybatisPlus的代码生成器插件时，如果jar包中包含mapper对应的xml，会无法进行sql绑定。

## 复现步骤

1. 准备MySQL数据库
2. 使用[建库建表SQL](jar-has-xml%2Fsrc%2Fmain%2Fresources%2Ftest.sql)进行表创建
4. 启动[access](./access/src/main/java/edu/yangao/access/AccessApplication.java)项目
5. 访问[测试地址](http://localhost:8092/test)
6. 项目报错
   ```bash
    org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): edu.yangao.jarhasxml.mapper.TestMapper.test
    at org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:229) ~[mybatis-3.5.15.jar:3.5.15]
    at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.<init>(MybatisMapperMethod.java:50) ~[mybatis-plus-core-3.5.5.jar:3.5.5]
    at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.lambda$cachedInvoker$0(MybatisMapperProxy.java:111) ~[mybatis-plus-core-3.5.5.jar:3.5.5]
    at java.base/java.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1708) ~[na:na]
    at com.baomidou.mybatisplus.core.toolkit.CollectionUtils.computeIfAbsent(CollectionUtils.java:157) ~[mybatis-plus-core-3.5.5.jar:3.5.5]
    at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.cachedInvoker(MybatisMapperProxy.java:98) ~[mybatis-plus-core-3.5.5.jar:3.5.5]
    at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:89) ~[mybatis-plus-core-3.5.5.jar:3.5.5]
    at jdk.proxy2/jdk.proxy2.$Proxy60.test(Unknown Source) ~[na:na]
    at edu.yangao.jarhasxml.controller.TestController.test(TestController.java:20) ~[jar-has-xml-0.0.1-SNAPSHOT.jar:na]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
    at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
    at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.23.jar:5.3.23]
    at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1071) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:964) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:670) ~[tomcat-embed-core-9.0.68.jar:4.0.FR]
    at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.23.jar:5.3.23]
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:779) ~[tomcat-embed-core-9.0.68.jar:4.0.FR]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.23.jar:5.3.23]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.23.jar:5.3.23]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.23.jar:5.3.23]
    at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.23.jar:5.3.23]
    at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.StandardContextValve.__invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:41002) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1789) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.68.jar:9.0.68]
    at java.base/java.lang.Thread.run(Thread.java:840) ~[na:na]
    ```

## 项目启动注意事项

> 如果不注意的话，可以会无法重现

1. 不要将jar-has-xml作为maven导入项目

    如果不小心导入了，那么将对应文件夹模块移除，然后将目录移出项目目录，再将其移动回来。
