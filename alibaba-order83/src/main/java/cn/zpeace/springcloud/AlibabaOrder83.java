package cn.zpeace.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zpeace
 * @date 2021/1/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrder83.class,args);
    }
}
