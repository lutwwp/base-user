package com.wwp.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Page
 * @Description: TODO
 * @Author wwp
 * @Date 2019-11-01
 * @Version V1.0
 **/
@Configuration
public class PaginationConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
