package cn.zpeace.springcloud.controller;

import cn.zpeace.springcloud.entity.Payment;
import cn.zpeace.springcloud.entity.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zpeace
 * @date 2020/12/24
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final String PAYMENT_SERVICE = "http://payment-service";

    private final RestTemplate restTemplate;

    @GetMapping("/order/payment")
    public ResultVO<?> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_SERVICE + "/payment",payment, ResultVO.class);
    }

    @GetMapping("/order/payment/{id}")
    public ResultVO<?> query(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SERVICE + "/payment/" + id, ResultVO.class);
    }
}
