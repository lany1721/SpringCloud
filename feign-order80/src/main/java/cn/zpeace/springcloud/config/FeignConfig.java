package cn.zpeace.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zpeace
 * @date 2020/12/26
 */
@Configuration
public class FeignConfig {

    /**
     * feign 的日志级别显示
     */
    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
