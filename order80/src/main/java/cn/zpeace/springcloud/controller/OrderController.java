package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.entity.ResultVO;
import cn.zpeace.springcloud.lb.LoadBalancer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author zpeace
 * @date 2020/12/24
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final String PAYMENT_SERVICE = "http://PAYMENT-SERVICE";

    private final RestTemplate restTemplate;

    private final LoadBalancer loadBalancer;

    private final DiscoveryClient discoveryClient;

    @GetMapping("/order/payment")
    public ResultVO<?> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SERVICE + "/payment",payment, ResultVO.class);
    }

    @GetMapping("/order/payment/{id}")
    public ResultVO<?> query(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/" + id, ResultVO.class);
    }

    @GetMapping("/order/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri +"/payment/lb",String.class);
    }
}
