package cn.zpeace.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zpeace
 * @date 2021/1/7
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaPayment9003 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9003.class,args);
    }
}
