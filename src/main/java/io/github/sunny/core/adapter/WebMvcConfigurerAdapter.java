/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.core.adapter;

import io.github.sunny.bean.WebBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaoyunxing
 * @date: 2019-08-27 17:49
 * @des:
 */
@Slf4j
@Configuration
@ConditionalOnClass(WebBean.class)
@ConditionalOnWebApplication
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
    public WebMvcConfigurerAdapter() {
        log.error("WebMvcConfigurerAdapter bean loading....");
    }
}
