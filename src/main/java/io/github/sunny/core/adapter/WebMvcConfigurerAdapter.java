/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.core.adapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import io.github.sunny.bean.WebBean;
import io.github.sunny.core.adapter.util.FastJsonConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

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

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 删除MappingJackson2HttpMessageConverter
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                SerializerFeature.WriteMapNullValue,
                // todo: 解决 BigDecimal整数补位问题注释该代码，否则null的值都转为0
                // SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect,
        };
        FastJsonConverterUtil.setFastJsonConverter(converters, fastConverter, fastJsonConfig, serializerFeatures);
    }

}
