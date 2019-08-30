/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.core.adapter;

import io.github.sunny.bean.AppBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaoyunxing
 * @date: 2019-08-30 09:36
 * @des:
 */
@Slf4j
@Configuration
@ConditionalOnClass(AppBean.class)
@ConditionalOnWebApplication
public class AppWebMvcConfigurerAdapter implements WebMvcConfigurer {

    public AppWebMvcConfigurerAdapter() {
        log.error("AppBean...");
    }
}
