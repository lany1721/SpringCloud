package cn.zpeace.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zpeace
 * @date 2020/12/26
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
