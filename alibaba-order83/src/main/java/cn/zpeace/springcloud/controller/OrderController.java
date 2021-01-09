package cn.zpeace.springcloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zpeace
 * @date 2021/1/4
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RestTemplate restTemplate;

    @Value("${rpc.payment-service}")
    private String paymentService;

    @GetMapping(value = "/order/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") String id)
    {
        return restTemplate.getForObject(paymentService+"/payment/nacos/"+id,String.class);
    }
}
