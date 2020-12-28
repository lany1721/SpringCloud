package cn.zpeace.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zpeace
 * @date 2020/12/28
 */
@FeignClient(value = "HYSTRIX-PAYMENT",fallback = FeignPaymentServiceImpl.class)
@Service
public interface FeignPaymentService {

    @GetMapping("/payment/success/{id}")
    String success(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout/{id}")
    String timeout(@PathVariable("id") Long id);
}
