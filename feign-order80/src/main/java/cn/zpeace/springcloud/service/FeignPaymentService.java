package cn.zpeace.springcloud.service;

import cn.zpeace.springcloud.entity.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用PAYMENT-SERVICE服务
 * @author zpeace
 * @date 2020/12/26
 */
@Component
@FeignClient("PAYMENT-SERVICE")
public interface FeignPaymentService {

    @GetMapping("/payment/{id}")
    ResultVO<?> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
