package cn.zpeace.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zpeace
 * @date 2021/1/7
 */
@FeignClient(value = "payment-service",fallback = FeignPaymentServiceImpl.class)
public interface FeignPaymentService {

    @GetMapping("/payment/{id}")
    String getPayment(@PathVariable("id") Long id);
}
