//package com.wwp.demo.config;
//
//import com.wwp.demo.interceptor.MyInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @ClassName WebMvcConfiguration
// * @Description: TODO
// * @Author wwp
// * @Date 2019-10-31
// * @Version V1.0
// **/
//@Configuration
//public class WebMvcConfiguration implements WebMvcConfigurer {
//
//    @Autowired
//    private MyInterceptor myInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor).addPathPatterns().excludePathPatterns();
//    }
//}
