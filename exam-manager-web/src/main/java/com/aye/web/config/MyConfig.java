package com.aye.web.config;

import com.aye.web.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;


/**
 * @author Aye
 * @version $Id: MyConfig, v 0.1 2019/3/26 15:33 Aye Exp$
 */
//使用webConfigAdapter扩MVC的功能
@Configuration
public class MyConfig  {

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //浏览器发送/viewResolver 请求 跳转sucess.html页面
        registry.addViewController("/viewResolver").setViewName("sucess");
        //registry.addViewController("/*").setViewName("login");
    }*/


    //使用webConfigAdapter扩MVC的功能
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurerAdapter(){
//        WebMvcConfigurationSupport adapter = new WebMvcConfigurationSupport() {
//            //跳转指定页面
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//            }
//            //注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
//            }
//        };
//        return adapter;
//    }

    //加载国际化解析器到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
