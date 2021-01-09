package cn.zpeace.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zpeace
 * @date 2021/1/5
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Sentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401.class,args);
    }
}
