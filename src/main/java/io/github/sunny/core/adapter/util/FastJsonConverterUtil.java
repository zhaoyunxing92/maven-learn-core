/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.core.adapter.util;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyunxing
 * @date: 2019-09-02 16:09
 * @des:
 */
public class FastJsonConverterUtil {

    private FastJsonConverterUtil() {
    }

    /**
     * 设置使用fast json处理返回数据
     *
     * @param converters         转换器
     * @param fastConverter      fastjson的转换器
     * @param fastJsonConfig     配置
     * @param serializerFeatures 序列化策略
     */
    public static void setFastJsonConverter(List<HttpMessageConverter<?>> converters, FastJsonHttpMessageConverter fastConverter, FastJsonConfig fastJsonConfig, SerializerFeature[] serializerFeatures) {

        SerializeConfig serializeConfig = SerializeConfig.globalInstance;

        // serializeConfig.put(BigDecimal.class, BigDecimalFormat.instance);

        fastJsonConfig.setSerializeConfig(serializeConfig);
        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypes = new ArrayList<>();
        //设定json格式且编码为UTF-8
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(fastConverter);
    }
}
