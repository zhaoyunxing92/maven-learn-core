/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.core.adapter;

import io.github.sunny.bean.AppBean;
import io.github.sunny.bean.WebBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoyunxing
 * @date: 2019-09-02 12:07
 * @des:
 */
@Slf4j
@Configuration
@ConditionalOnWebApplication
public class CcclubsApiAutoConfiguration {

    public CcclubsApiAutoConfiguration() {
        log.info("CcclubsApiAutoConfiguration..................");
    }

    @Bean
    @ConditionalOnClass(AppBean.class)
    public AppWebMvcConfigurerAdapter appWebMvcConfigurerAdapter() {
        return new AppWebMvcConfigurerAdapter();
    }

    @Bean
    @ConditionalOnClass(WebBean.class)
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter();
    }
}
